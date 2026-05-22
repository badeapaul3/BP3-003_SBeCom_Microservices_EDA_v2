package com.config.configdemo;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paul Badea
 **/
@RestController
@RefreshScope
//@AllArgsConstructor
public class BuildInfoController {
    @Value("${build.id:default}")
    private String buildId;
    @Value("${build.version}")
    private String buildVersion;
    @Value("${build.name}")
    private String buildName;

//    private BuildInfo buildInfo;

//    @GetMapping("/build-info")
//    public String getBuildInfo(){
//        return "Build ID: " + buildInfo.getId() + "\n" +
//                "Build Version: " + buildInfo.getVersion() + "\n" +
//                "Build Name: " + buildInfo.getName();
//    }

    @GetMapping("/build-info")
    public String getBuildInfo(){
        return "Build ID: " + buildId + "\n" +
                "Build Version: " + buildVersion + "\n" +
                "Build Name: " + buildName;
    }

}
