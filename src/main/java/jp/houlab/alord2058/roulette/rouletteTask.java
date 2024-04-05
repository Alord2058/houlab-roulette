package jp.houlab.alord2058.roulette;

import net.kyori.adventure.audience.Audience;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
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

    public void showMyTitle(final @NonNull Audience target, int rouletteNumber) {

        Title.Times times = Title.Times.times(Duration.ofMillis(0), Duration.ofMillis(3000), Duration.ofMillis(1000));

        final Component mainTitle = Component.text(rouletteNumber, NamedTextColor.WHITE);
        final Component subtitle = Component.empty();

        // Creates a simple title with the default values for fade-in, stay on screen and fade-out durations
        final Title title = Title.title(mainTitle, subtitle,times);

        // Send the title to your audience
        target.showTitle(title);
    }

    @Override
    public void run() {

        Random rand = new Random();
        int rouletteNumber = rand.nextInt(6) + 1;

        if (count <= 100 && count > 90) {
            count--;
            Audience players = this.plugin.adventure().players();
            showMyTitle(players, rouletteNumber);
            Sound noteBlockHat = Sound.sound(Key.key("block.note_block.hat"), Sound.Source.MASTER, 1f, 1f);
            players.playSound(noteBlockHat);


        } else if (count <= 90 && count > 70) {
            if (count % 2 == 0) {
                count--;
                Audience players = this.plugin.adventure().players();
                showMyTitle(players, rouletteNumber);
                Sound noteBlockHat = Sound.sound(Key.key("block.note_block.hat"), Sound.Source.MASTER, 1f, 1f);
                players.playSound(noteBlockHat);

            } else {
                count--;
            }

        } else if (count <= 70 && count > 50) {
            if (count % 3 == 0) {
                count--;
                Audience players = this.plugin.adventure().players();
                showMyTitle(players, rouletteNumber);
                Sound noteBlockHat = Sound.sound(Key.key("block.note_block.hat"), Sound.Source.MASTER, 1f, 1f);
                players.playSound(noteBlockHat);

            } else {
                count--;
            }

        } else if (count <= 50 && count > 30){
            if (count % 4 == 0) {
                count--;
                Audience players = this.plugin.adventure().players();
                showMyTitle(players, rouletteNumber);
                Sound noteBlockHat = Sound.sound(Key.key("block.note_block.hat"), Sound.Source.MASTER, 1f, 1f);
                players.playSound(noteBlockHat);

            } else {
                count--;
            }

        } else if (count <= 30 && count > 0) {
            if (count % 15 == 0) {
                count--;
                Audience players = this.plugin.adventure().players();
                showMyTitle(players, rouletteNumber);
                Sound noteBlockHat = Sound.sound(Key.key("block.note_block.hat"), Sound.Source.MASTER, 1f, 1f);
                players.playSound(noteBlockHat);

            } else {
                count--;
            }

        } else {
            switch (rouletteNumber) {
                case 1 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound villagerSound = Sound.sound(Key.key("entity.villager.ambient"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(villagerSound);
                    this.cancel();
                }

                case 2 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound catSound = Sound.sound(Key.key("entity.cat.stray_ambient"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(catSound);
                    this.cancel();
                }

                case 3 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound fireworkSound = Sound.sound(Key.key("entity.firework_rocket.launch"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(fireworkSound);
                    this.cancel();
                }

                case 4 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound blazeShootSound = Sound.sound(Key.key("entity.blaze.shoot"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(blazeShootSound);
                    this.cancel();
                }

                case 5 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound goat_hornSound = Sound.sound(Key.key("item.goat_horn.sound.0"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(goat_hornSound);
                    this.cancel();
                }

                case 6 -> {
                    Audience players = this.plugin.adventure().players();
                    showMyTitle(players, rouletteNumber);
                    Sound ender_DragonAmbientSound = Sound.sound(Key.key("entity.ender_dragon.ambient"), Sound.Source.MASTER, 1f, 1f);
                    players.playSound(ender_DragonAmbientSound);
                    this.cancel();
                }
            }
        }
    }
}