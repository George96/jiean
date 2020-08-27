package com.jiean.web.controller.monitor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jiean.common.core.controller.BaseController;
import com.jiean.common.core.domain.RestResponse;
import com.jiean.framework.web.domain.Server;

/**
 * 服务器监控
 *
 * @author george
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController extends BaseController {
    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public RestResponse getInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        return RestResponse.success(server);
    }
}
