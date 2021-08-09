package com.fengjin.success.facade;

import lombok.AllArgsConstructor;

/**
 * @author fengjin
 * @Data 2021/8/9
 * @Description 致敬大师，致敬未来的你
 */
public class Facade {
    // 定义子系统的各个对象
    private TheaterLight theaterLight;
    private Popcorn popcorn;
    private Porjector porjector;
    private Stereo stereo;
    private Screen screen;
    private DVDPlayer dvdPlayer;

    public Facade() {
        this.theaterLight = TheaterLight.getInstance();
        this.popcorn = Popcorn.getInstance();
        this.porjector = Porjector.getInstance();
        this.stereo = Stereo.getInstance();
        this.screen = Screen.getInstance();
        this.dvdPlayer = DVDPlayer.getInstance();
    }

    public void ready() {
        popcorn.on();
        popcorn.play();
        screen.down();
        porjector.on();
        stereo.on();
        dvdPlayer.on();
        theaterLight.dim();
    }

    public void play() {
        dvdPlayer.play();
    }

    public void pause() {
        dvdPlayer.pause();
    }

    public void end() {
        popcorn.off();
        screen.up();
        porjector.off();
        stereo.off();
        dvdPlayer.off();
        theaterLight.bright();
    }

    public static void main(String[] args) {

    }
}
