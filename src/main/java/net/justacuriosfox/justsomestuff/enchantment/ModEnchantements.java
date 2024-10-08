package net.justacuriosfox.justsomestuff.enchantment;

import net.justacuriosfox.justsomestuff.JustSomeStuffMod;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;

public class ModEnchantements {
    public static Enchantment AFFECTING = register("affecting",
            new AffectingEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment YEET = register("yeet",
            new YeetEnchantment(Enchantment.Rarity.UNCOMMON,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment LIFESTEAL = register("lifesteal",
            new LifestealEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment PULL = register("pull",
            new PullEnchantment(Enchantment.Rarity.RARE,
                    EnchantmentTarget.WEAPON, EquipmentSlot.MAINHAND));
    public static Enchantment POWERLESS_CURSE = register("powerless_curse",
            new PowerlessCurseEnchantment(Enchantment.Rarity.VERY_RARE,
                    EnchantmentTarget.BREAKABLE, EquipmentSlot.MAINHAND));

    private static Enchantment register(String name, Enchantment enchantment) {
        return Registry.register(Registries.ENCHANTMENT, new Identifier(JustSomeStuffMod.MOD_ID, name), enchantment);
    }

    public static void registerModEnchantments() {
        JustSomeStuffMod.LOGGER.info("Registering Enchantments for " + JustSomeStuffMod.MOD_ID);
    }
}
