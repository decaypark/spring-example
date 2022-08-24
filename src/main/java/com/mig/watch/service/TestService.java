package com.mig.watch.service;

import com.mig.watch.dao.SaltTstReqBdInsertDao;
import com.mig.watch.dao.SaltTstReqBdSelectDao;
import com.mig.watch.vo.SaltTstReqBdVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestService {

    @Autowired
    public SaltTstReqBdSelectDao saltTstReqBdSelectDao;

    @Autowired
    public SaltTstReqBdInsertDao saltTstReqBdInsertDao;


    public int getTestMain () {
        int rtn = 0;
        log.info("TestMain");

        StopWatch timer = new StopWatch();
        timer.start();
        log.info("getSaltTstReqBdMain ----------------------------------------------------------------------------------------------------------- START");
        List<SaltTstReqBdVO> list = new ArrayList<SaltTstReqBdVO>();
        int s = 1000000;
        int x = 50000;
        for (int i = 0; i < s; i+= x ) {

            StopWatch timerS = new StopWatch();
            timerS.start();
            int j = i + x;
            if (j >= s) j = s;
            log.info("i..........+ = {}", i + 1 + "/" + x);
            list.addAll((List<SaltTstReqBdVO>) saltTstReqBdSelectDao.selectPaging(i + 1, x, x));

            timerS.stop();

            log.info("SELECT -> {}  ", timerS.getTotalTimeSeconds());
            log.info("list.SIZE() = {}", list.size());
            this.setBdTmp(list);
            list.clear();
        }
        timer.stop();
        log.info("getSaltTstReqBdMain -> Total time in seconds: " + timer.getTotalTimeSeconds());
        log.info("getSaltTstReqBdMain ----------------------------------------------------------------------------------------------------------- END");



        return rtn;
    }

    public void setBdTmp (List<SaltTstReqBdVO> list) {
        int s = list.size();
        for (int i = 0; i < s; i+= 10000) {
            int j = i + 10000;
            if (j >= s) j = s;
            saltTstReqBdInsertDao.batchInsert(list.subList(i, j));
        }
    }
}
