package hat.waywardalchemist.block;

import hat.waywardalchemist.WaywardAlchemist;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class WaywardAlchemistBlocks {

    public static Block BOILING_BREWER_BLOCK = registerBlock("boiling_brewer_block",
            new BoilingBrewerBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.CYAN)
                    .instrument(NoteBlockInstrument.XYLOPHONE)
                    .requiresTool()
                    .strength(0.5f, 3.0f)
                    .sounds(BlockSoundGroup.COPPER_BULB)
                    .registryKey(createBlockRegistryKey("boiling_brewer_block"))));


    private static RegistryKey<Block> createBlockRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WaywardAlchemist.MOD_ID, name));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, createBlockRegistryKey(name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WaywardAlchemist.MOD_ID, name));
        Registry.register(Registries.ITEM, itemKey,
                new BlockItem(block, new Item.Settings()
                        .useBlockPrefixedTranslationKey()
                        .registryKey(itemKey)));

    }

    public static void registerWABlocks() {
        WaywardAlchemist.LOGGER.info("Registering blocks for " + WaywardAlchemist.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(WaywardAlchemistBlocks.BOILING_BREWER_BLOCK);
        });
    }

}

//    new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
//                .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(WaywardAlchemist.MOD_ID, name))));
//
//    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
//        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(WaywardAlchemist.MOD_ID, name))));
//        registerBlockItem(name, toRegister);
//        return Registry.register(Registries.BLOCK, Identifier.of(WaywardAlchemist.MOD_ID,name), toRegister);
//    }