package jp.houlab.alord2058.roulette;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.title.Title;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.time.Duration;
import java.util.Random;

public class rouletteTask extends BukkitRunnable {

    private final Roulette plugin;
    private int count;

    public rouletteTask (Roulette plugin, int count) {
        this.plugin = plugin;

        if (count < 1) {
            throw new IllegalArgumentException("count error.");
        } else {
            this.count = count;
        }
    }

    public void playSoundTitle(final @NonNull Audience players, int rouletteNumber, String sound, TextColor coloring, float volume) {

        Title.Times times = Title.Times.times(Duration.ofMillis(0), Duration.ofMillis(3000), Duration.ofMillis(1000));

        final Component mainTitle = Component.text(rouletteNumber,coloring);
        final Component subtitle = Component.empty();

        // Creates a simple title with the default values for fade-in, stay on screen and fade-out durations
        final Title title = Title.title(mainTitle, subtitle,times);

        // Send the title to your audience
        players.showTitle(title);

        Sound chooseSound = Sound.sound(Key.key(sound), Sound.Source.MASTER, volume, 1f);
        players.playSound(chooseSound);
    }

    String noteBlockHat = "block.note_block.hat";
    String villagerAmbient = "entity.villager.ambient";
    String catStrayAmbient ="entity.cat.stray_ambient";
    String fireworkRocketLaunch ="entity.firework_rocket.launch";
    String blazeShoot ="entity.blaze.shoot";
    String goatHornSound0 ="item.goat_horn.sound.0";
    String enderDragonAmbient ="entity.ender_dragon.ambient";

    float volume = 0.9f;

    int r = 0;
    int g = 0;
    int b = 237;

    int rouletteNumber = 0;

    @Override
    public void run() {

        int countB = this.plugin.getConfig().getInt("count");
        Audience players = this.plugin.adventure().players();

        if (count <= countB && count > countB - 10) {
            count--;
            g += 23;
            Random rand = new Random();
            rouletteNumber = rand.nextInt(6) + 1;
            playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(r,g,b), volume);

        } else if (count <= countB - 10 && count > countB - 30) {
            if (count % 2 == 0) {
                count--;
                b -= 11;
                Random rand = new Random();
                rouletteNumber = rand.nextInt(6) + 1;
                playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(r,g,b), volume);

            } else {
                count--;
                b -= 11;
            }

        } else if (count <= countB - 30 && count > countB - 50) {
            if (count % 3 == 0) {
                count--;
                r += 11;
                Random rand = new Random();
                rouletteNumber = rand.nextInt(6) + 1;
                playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(r,g,b), volume);

            } else {
                count--;
                r += 11;
            }

        } else if (count <= countB - 50 && count > countB - 70){
            if (count % 4 == 0) {
                count--;
                g -= 11;
                Random rand = new Random();
                rouletteNumber = rand.nextInt(6) + 1;
                playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(r,g,b), volume);

            } else {
                count--;
                g -= 11;
            }

        } else if (count <= countB - 70 && count > countB - 100) {
            if (count % 15 == 0) {
                count--;
                Random rand = new Random();
                rouletteNumber = rand.nextInt(6) + 1;
                playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(r,g,b), volume);

            } else {
                count--;
            }

        } else if (count == countB - 100) {
            count--;
            Random rand = new Random();
            rouletteNumber = rand.nextInt(6) + 1;
            switch (rouletteNumber) {
                case 1 -> {
                    volume = 0.75f;
                    playSoundTitle(players, rouletteNumber,villagerAmbient,TextColor.color(237,0,0),volume);
                }
                case 2 -> {
                    volume = 1.0f;
                    playSoundTitle(players, rouletteNumber,catStrayAmbient,TextColor.color(237,0,0),volume);
                }
                case 3 -> {
                    volume = 0.75f;
                    playSoundTitle(players, rouletteNumber,fireworkRocketLaunch,TextColor.color(237,0,0),volume);
                }
                case 4 -> {
                    volume = 0.75f;
                    playSoundTitle(players, rouletteNumber,blazeShoot,TextColor.color(237,0,0),volume);
                }
                case 5 -> {
                    volume = 0.75f;
                    playSoundTitle(players, rouletteNumber,goatHornSound0,TextColor.color(237,0,0),volume);
                }
                case 6 -> {
                    volume = 0.3f;
                    playSoundTitle(players, rouletteNumber,enderDragonAmbient,TextColor.color(237,0,0),volume);

                }
            }
        } else if (count < countB - 100 && count > countB - 120) {
            count--;

        } else if (count == countB - 120) {
            count--;
            volume = 0.0f;
            playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(237,237,0), volume);

        } else if (count < countB - 120 && count > countB - 140) {
            count--;

        } else if (count == countB - 140)  {
            count--;
            playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(237,0,0), volume);

        } else if (count < countB - 140 && count > countB - 160) {
            count--;

        } else if (count == countB - 160)  {
            count--;
            playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(237,237,0), volume);

        } else if (count < countB - 160 && count > 0) {
            count--;

        } else if (count == 0)  {
            playSoundTitle(players, rouletteNumber,noteBlockHat,TextColor.color(237,0,0), volume);
            this.cancel();
        }
    }
}