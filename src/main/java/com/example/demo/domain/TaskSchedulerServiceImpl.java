package com.example.demo.domain;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

@Service
public class TaskSchedulerServiceImpl {

//  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(4);
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

  // schedule() - Ejecuta una tarea con un retraso
  public void scheduleTask(Runnable task, long delay, TimeUnit unit) {
    scheduler.schedule(task, delay, unit);
  }

  // scheduleAtFixedRate() - Ejecuta una tarea a intervalos fijos
  public void scheduleAtFixedRate(Runnable task, long initialDelay, long period, TimeUnit unit) {
    scheduler.scheduleAtFixedRate(task, initialDelay, period, unit);
  }

  // scheduleWithFixedDelay() - Ejecuta una tarea con un retraso fijo entre ejecuciones
  public void scheduleWithFixedDelay(Runnable task, long initialDelay, long delay, TimeUnit unit) {
    scheduler.scheduleWithFixedDelay(task, initialDelay, delay, unit);
  }

  // submit() - Ejecuta una tarea una sola vez sin retraso
  public void submitTask(Runnable task) {
    scheduler.submit(task);
  }

  public String showLog() {
    return scheduler.toString();
  }

}
