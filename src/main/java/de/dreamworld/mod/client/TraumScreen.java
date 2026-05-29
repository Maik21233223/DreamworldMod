package de.dreamworld.mod.client;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class TraumScreen extends Screen {

    public TraumScreen() {
        super(Component.literal(""));
    }

    @Override
    protected void init() {
        this.addRenderableWidget(
                Button.builder(Component.literal("Träumen"), button -> {
                    this.minecraft.setScreen(null);
                }).bounds(this.width / 2 - 100, this.height / 2 - 25, 200, 20).build()
        );

        this.addRenderableWidget(
                Button.builder(Component.literal("Durchschlafen"), button -> {
                    this.minecraft.setScreen(null);
                }).bounds(this.width / 2 - 100, this.height / 2 + 5, 200, 20).build()
        );
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float delta) {
        super.extractRenderState(graphics, mouseX, mouseY, delta);

        graphics.text(
                this.font,
                this.title,
                this.width / 2 - this.font.width(this.title) / 2,
                this.height / 2 - 60,
                0xFFFFFFFF,
                false
        );
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}