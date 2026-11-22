package dev.sypherox;

import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.layouts.HeaderAndFooterLayout;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;

public class ConfigScreen extends Screen {
    private final Screen parent;
    private final HeaderAndFooterLayout layout = new HeaderAndFooterLayout(this);

    public ConfigScreen(Screen parent) {
        super(Component.translatable("hotbaritemname.config.title"));
        this.parent = parent;
    }

    @Override
    protected void init() {
        layout.addTitleHeader(this.title, this.font);

        layout.addToContents(Button.builder(buttonText(), button -> {
            ModConfig config = ModConfig.get();
            config.showHeldItemName = !config.showHeldItemName;
            ModConfig.save();
            button.setMessage(buttonText());
        }).width(250).build());

        layout.addToFooter(Button.builder(CommonComponents.GUI_DONE, button -> onClose()).width(200).build());

        layout.visitWidgets(this::addRenderableWidget);
        repositionElements();
    }

    @Override
    protected void repositionElements() {
        layout.arrangeElements();
    }

    @Override
    public void onClose() {
        ModConfig.save();
        this.minecraft.setScreenAndShow(parent);
    }

    private static Component buttonText() {
        Component state = ModConfig.get().showHeldItemName ? CommonComponents.OPTION_ON : CommonComponents.OPTION_OFF;
        return Component.translatable("hotbaritemname.config.show_item_name", state);
    }
}
