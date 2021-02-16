package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmailScheduler {
    private static final String SUBJECT = "Task: Once a day email";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {
        long size = taskRepository.count();
        String message;

        if (size == 1) {
            message = "Currently in database you got: " + size + " task";
        } else {
            message = "Currently in database you got: " + size + " tasks";
        }

        Mail mail = Mail.builder()
                .mailTo(adminConfig.getAdminMail())
                .subject(SUBJECT)
                .message(message)
                .build();

        simpleEmailService.send(mail);
    }
}
