package hat.waywardalchemist.datagen;

import hat.waywardalchemist.WaywardAlchemist;
import hat.waywardalchemist.items.WaywardAlchemistItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.AbstractCriterion;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.advancement.criterion.UsingItemCriterion;
import net.minecraft.data.advancement.AdvancementProvider;
import net.minecraft.item.Items;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.awt.*;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class WaywardAlchemistAdvancementProvider  extends FabricAdvancementProvider {
    public WaywardAlchemistAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        Advancement.Builder.create()
                .display(
                        WaywardAlchemistItems.PUTREDO, // The display icon
                        Text.literal("The First Step"), // The title
                        Text.literal("§8Trivvlscwx uidhw vnk hr bdn wzi... §fDcpaq hhp qmuotp't klzdpe ibs... §6Iqov nbuj xqvkqzs kquxkpvny nwlk..."), // The description
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.GOAL, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        true // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("got_putredo", InventoryChangedCriterion.Conditions.items(WaywardAlchemistItems.PUTREDO))
                // Give the advancement an id
                .build(consumer, WaywardAlchemist.MOD_ID + ":putredo");

        Advancement.Builder.create()
                .display(
                        WaywardAlchemistItems.PHILOSOPHERS_ASH, // The display icon
                        Text.literal("The Incomplete Opus"), // The title
                        Text.literal("§4Zm frowxbuiqavhu arfkb ulh qfmu?"), // The description
                        Identifier.of("textures/gui/advancements/backgrounds/adventure.png"), // Background image for the tab in the advancements page, if this is a root advancement (has no parent)
                        AdvancementFrame.CHALLENGE, // TASK, CHALLENGE, or GOAL
                        true, // Show the toast when completing it
                        true, // Announce it to chat
                        true // Hide it in the advancement tab until it's achieved
                )
                // "got_dirt" is the name referenced by other advancements when they want to have "requirements."
                .criterion("made_philosophers_ash", InventoryChangedCriterion.Conditions.items(WaywardAlchemistItems.PHILOSOPHERS_ASH))
                // Give the advancement an id
                .build(consumer, WaywardAlchemist.MOD_ID + ":rubedo");
    }

}
