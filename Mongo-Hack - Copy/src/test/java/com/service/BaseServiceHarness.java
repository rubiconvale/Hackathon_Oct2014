package com.service;
/**
 * Copyright (c) 2014. PICS Auditing LLC. All Rights Reserved.  This file is privileged, confidential and exempt from disclosure
 * under applicable law.  If you have received this file in error, please notify PICS Auditing LLC immediately, and destroy
 * the original file and all copies thereof (including electronic media).
 */
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author RNatarajan on 6/7/2014.
 * Modification Log :
 */



@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations= {"classpath*:application-config.xml"})

public class BaseServiceHarness {

    protected final Logger log= LoggerFactory.getLogger(this.getClass());
    static {
        System.setProperty("SYS_ENV","local");
    }
    public void test(){
        log.debug("CLASS PATH :"+System.getProperty("java.class.path"));
    }
}

