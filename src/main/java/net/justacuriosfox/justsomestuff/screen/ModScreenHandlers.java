package net.justacuriosfox.justsomestuff.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static ScreenHandlerType<LSDFurnaceScreenHandler> LSDFURNACE_SCREEN_HANDLER;


    public static void registerAllScreenHandlers() {
        LSDFURNACE_SCREEN_HANDLER =
                ScreenHandlerRegistry.registerSimple(new Identifier(JustSomeStuffMod.MOD_ID, "lsdfurnace"),
                        LSDFurnaceScreenHandler::new);
    }
}
