package com.mig.watch;

import com.mig.watch.service.TestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@RequiredArgsConstructor
@Slf4j
public class TestWatch {

    @Autowired
    public TestService testService;

    @Async("threadPoolTaskExecutor")
    public void run() throws Exception {

        int result = -1;
        long delayTime = 10000;

        result = watch();
        /*
        while (true) {
            result = watch();
            if(result == 0) {
                try {
                    TimeUnit.MILLISECONDS.sleep(delayTime);
                } catch (InterruptedException e) {
                    log.error("Error Occurs!!", e);
                }
            }
        }*/

    }

    /**
     *
     * @return
     * @throws Exception
     */
    public int watch() throws Exception {
        log.debug("start of TestWatch testService.getTestMain ");
        int	result = testService.getTestMain();
        log.debug("end of TestWatch testService.getTestMain result.size() = {}", result);
        return result;
    }
}