package dev.sypherox;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

public class HotbarItemNameClient implements ClientModInitializer {
    public static final String MOD_ID = "hotbaritemname";

    @Override
    public void onInitializeClient() {
        ModConfig.load();
        HotbarItemNameCommand.register();

        HudElementRegistry.replaceElement(VanillaHudElements.HELD_ITEM_TOOLTIP, original ->
                (graphics, deltaTracker) -> {
                    if (ModConfig.get().showHeldItemName) {
                        original.extractRenderState(graphics, deltaTracker);
                    }
                });
    }
}
