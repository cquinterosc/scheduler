package com.example.demo.controller;

import com.example.demo.domain.TaskSchedulerServiceImpl;

import java.util.concurrent.TimeUnit;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scheduler")
public class DemoController {

  private final TaskSchedulerServiceImpl taskSchedulerService;

  public DemoController(TaskSchedulerServiceImpl taskSchedulerService) {
    this.taskSchedulerService = taskSchedulerService;
  }


  @PostMapping("/schedule")
  public String scheduleTask(@RequestParam long delay) {
    taskSchedulerService.scheduleTask(() -> System.out.println("Task executed with delay!"), delay, TimeUnit.SECONDS);
    return "Task scheduled with a delay of " + delay + " seconds.";
  }

  @PostMapping("/scheduleAtFixedRate")
  public String scheduleAtFixedRate(@RequestParam long initialDelay, @RequestParam long period) {
    taskSchedulerService.scheduleAtFixedRate(() -> System.out.println("Task executed at fixed rate!"), initialDelay, period, TimeUnit.SECONDS);
    return "Task scheduled at fixed rate every " + period + " seconds with an initial delay of " + initialDelay + " seconds.";
  }

  @PostMapping("/scheduleWithFixedDelay")
  public String scheduleWithFixedDelay(@RequestParam long initialDelay, @RequestParam long delay) {
    taskSchedulerService.scheduleWithFixedDelay(() -> System.out.println("Task executed with fixed delay!"), initialDelay, delay, TimeUnit.SECONDS);
    return "Task scheduled with a fixed delay of " + delay + " seconds, initial delay: " + initialDelay + " seconds.";
  }

  @PostMapping("/submit")
  public String submitTask() {
    taskSchedulerService.submitTask(() -> System.out.println("One-time task executed!"));
    return "One-time task submitted successfully.";
  }

  @PostMapping("/show")
  public String showLog() {
    return taskSchedulerService.showLog();
  }

}
