package com.greentrade.backend;

import com.greentrade.common.utils.CompareUtil;
import com.greentrade.common.utils.LoggingUtil;
import com.greentrade.worker.BaseWorker;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"com.greentrade.worker", "com.greentrade.backend"})
@EnableTransactionManagement
@EntityScan("com.greentrade.common.*")
@EnableJpaRepositories("com.greentrade.worker.persistence.jpa")
public class BackendApplication implements CommandLineRunner {
    private static Logger logger = LoggingUtil.createLogger(BackendApplication.class);
    @Autowired
    private BaseWorker worker;

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try {
            worker.start("TEST");
        } catch (Exception e) {
            logger.error("Error:start:worker: " + e.getMessage());
            try {
                if (!CompareUtil.isEqualsNull(worker)) {
                    worker.stop();
                }
            } catch (Exception ignored) {
            }
        }
    }
}
