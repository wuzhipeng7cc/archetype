package it.pkg.exporter;

import it.pkg.common.constant.Constant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wuzhipeng
 * @date 2020/2/2511:49 上午
 */
@FeignClient(name = Constant.APP_NAME)
@RequestMapping
public interface TestExporter {


    @RequestMapping("/hello")
    public void hello();
}
