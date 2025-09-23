package com.example.estruturarapida.controllers;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.function.Consumer;

public class TimeManager {

    private Timeline timeline;
    private int timeLeft;
    private final Runnable onFinish;

    /**
     * Starts a new timer with a specific duration (seconds)
     */
    public TimeManager(int seconds, Runnable onFinish) {
        this.timeLeft = seconds;
        this.onFinish = onFinish;
    }

    /**
     *Starts the countdown
     */
    public void start(Consumer<Integer> onTick) {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            timeLeft--;
            onTick.accept(timeLeft);
            if (timeLeft <= 0) {
                stop();
                onFinish.run();
            }
        }));
        timeline.setCycleCount(timeLeft);
        onTick.accept(timeLeft);
        timeline.play();
    }

    /**
     * Stops manually the countdown
     */
    public void stop() {
        if (timeline != null) timeline.stop();
    }

}
