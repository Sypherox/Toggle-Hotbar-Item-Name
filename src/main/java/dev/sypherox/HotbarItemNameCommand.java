package dev.sypherox;

import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.fabricmc.fabric.api.client.command.v2.ClientCommands;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.function.Consumer;

public class HotbarItemNameCommand {
    private static boolean openScreenNextTick = false;

    public static void register() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, buildContext) -> {
            for (String name : new String[] {"hotbaritemname", "HotBarItemName"}) {
                dispatcher.register(ClientCommands.literal(name)
                        .executes(context -> {
                            openScreenNextTick = true;
                            return 1;
                        })
                        .then(ClientCommands.literal("on")
                                .executes(context -> setShown(true, msg -> context.getSource().sendFeedback(msg))))
                        .then(ClientCommands.literal("off")
                                .executes(context -> setShown(false, msg -> context.getSource().sendFeedback(msg)))));
            }
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openScreenNextTick) {
                openScreenNextTick = false;
                client.setScreenAndShow(new ConfigScreen(null));
            }
        });
    }

    private static int setShown(boolean shown, Consumer<Component> feedback) {
        ModConfig.get().showHeldItemName = shown;
        ModConfig.save();
        feedback.accept(Component
                .translatable(shown ? "hotbaritemname.command.shown" : "hotbaritemname.command.hidden")
                .withStyle(shown ? ChatFormatting.GREEN : ChatFormatting.RED));
        return 1;
    }
}
