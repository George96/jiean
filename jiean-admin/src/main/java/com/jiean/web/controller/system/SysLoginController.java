package com.jiean.web.controller.system;

import java.util.List;
import java.util.Set;

import com.jiean.common.core.domain.RestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.jiean.common.constant.Constants;
import com.jiean.common.core.domain.entity.SysMenu;
import com.jiean.common.core.domain.entity.SysUser;
import com.jiean.common.core.domain.model.LoginBody;
import com.jiean.common.core.domain.model.LoginUser;
import com.jiean.common.utils.ServletUtils;
import com.jiean.framework.web.service.SysLoginService;
import com.jiean.framework.web.service.SysPermissionService;
import com.jiean.framework.web.service.TokenService;
import com.jiean.system.service.ISysMenuService;

/**
 * 登录验证
 *
 * @author george
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private TokenService tokenService;

    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public RestResponse login(@RequestBody LoginBody loginBody) {
        RestResponse restResponse = RestResponse.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        restResponse.put(Constants.TOKEN, token);
        return restResponse;
    }

    /**
     * 获取用户信息
     *
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public RestResponse getInfo() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        SysUser user = loginUser.getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        RestResponse restResponse = RestResponse.success();
        restResponse.put("user", user);
        restResponse.put("roles", roles);
        restResponse.put("permissions", permissions);
        return restResponse;
    }

    /**
     * 获取路由信息
     *
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public RestResponse getRouters() {
        LoginUser loginUser = tokenService.getLoginUser(ServletUtils.getRequest());
        // 用户信息
        SysUser user = loginUser.getUser();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(user.getUserId());
        return RestResponse.success(menuService.buildMenus(menus));
    }
}
