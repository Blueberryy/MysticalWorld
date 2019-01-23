package epicsquid.mysticalworld.init;

import javax.annotation.Nonnull;

import epicsquid.mysticallib.LibRegistry;
import epicsquid.mysticallib.block.BlockBase;
import epicsquid.mysticallib.block.BlockMushroomBase;
import epicsquid.mysticallib.block.BlockSlabBase;
import epicsquid.mysticallib.block.BlockStairsBase;
import epicsquid.mysticallib.block.BlockWallBase;
import epicsquid.mysticallib.event.RegisterContentEvent;
import epicsquid.mysticalworld.MysticalWorld;
import epicsquid.mysticalworld.block.BlockAubergineCrop;
import epicsquid.mysticalworld.block.BlockMoonglowCrop;
import epicsquid.mysticalworld.block.BlockPereskiaCrop;
import epicsquid.mysticalworld.block.BlockSpiritHerbCrop;
import epicsquid.mysticalworld.block.BlockThatch;
import epicsquid.mysticalworld.block.BlockWildrootCrop;
import epicsquid.mysticalworld.config.ConfigManager;
import epicsquid.mysticalworld.world.HugeBaffleCap;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.EnumPlantType;

public class ModBlocks {

  // All blocks
  public static Block moonglow, aubergine, pereskia, wildroot, spirit_herb, thatch, caminite, caminite_stairs, caminite_slab, caminite_wall, caminite_bricks, caminite_bricks_stairs, caminite_bricks_slab, caminite_bricks_wall, sunburnt_stone, sunburnt_stone_stairs, sunburnt_stone_slab, sunburnt_stone_wall,
      baffle_cap_huge_stem, baffle_cap_huge_top, baffle_cap_mushroom;

  /**
   * Register all blocks
   */
  public static void registerBlocks(@Nonnull RegisterContentEvent event) {

    BlockSlabBase slab_temp, double_slab_temp;

    if (ConfigManager.modules.rootsModuleEnabled) {
      // Roots
      event.addBlock(moonglow = new BlockMoonglowCrop("moonglow_crop", EnumPlantType.Crop));
      event.addBlock(aubergine = new BlockAubergineCrop("aubergine_crop", EnumPlantType.Crop));
      event.addBlock(pereskia = new BlockPereskiaCrop("pereskia_crop", EnumPlantType.Crop));
      event.addBlock(wildroot = new BlockWildrootCrop("wildroot_crop", EnumPlantType.Crop));
      event.addBlock(spirit_herb = new BlockSpiritHerbCrop("spirit_herb_crop", EnumPlantType.Crop));
      event.addBlock(thatch = new BlockThatch(Material.LEAVES, SoundType.PLANT, 0.8f, "thatch")).setCreativeTab(MysticalWorld.tab);
      event.addBlock(baffle_cap_huge_stem = new BlockBase(Material.CACTUS, SoundType.SLIME, 0.8f, "baffle_cap_huge_stem").setModelCustom(true).setCreativeTab(MysticalWorld.tab));
      event.addBlock(baffle_cap_huge_top = new BlockBase(Material.CACTUS, SoundType.SLIME, 0.8f, "baffle_cap_huge_top").setModelCustom(true).setCreativeTab(MysticalWorld.tab));
      event.addBlock(baffle_cap_mushroom = new BlockMushroomBase("baffle_cap_mushroom", new HugeBaffleCap().getData()));

      // Post registration block setup
      ((BlockMushroomBase) baffle_cap_mushroom).setItemBlock(new ItemBlock(baffle_cap_mushroom).setRegistryName(LibRegistry.getActiveModid(), "baffle_cap_mushroom"));
    }

    if (ConfigManager.modules.embersModuleEnabled) {
      // Embers
      event.addBlock(caminite = new BlockBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite").setModelCustom(true).setCreativeTab(MysticalWorld.tab));
      event.addBlock(caminite_stairs = new BlockStairsBase(caminite.getDefaultState(), SoundType.STONE, 2.0f, "caminite_stairs").setModelCustom(true)
          .setCreativeTab(MysticalWorld.tab));
      double_slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite_double_slab", caminite.getDefaultState(), true, null)
          .setModelCustom(true);
      slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite_slab", caminite.getDefaultState(), false, double_slab_temp)
          .setModelCustom(true);
      double_slab_temp.setSlab(slab_temp);
      event.addBlock(caminite_slab = slab_temp.setCreativeTab(MysticalWorld.tab));
      event.addBlock(double_slab_temp);
      event
          .addBlock(caminite_wall = new BlockWallBase(caminite, SoundType.STONE, 2.0f, "caminite_wall").setModelCustom(true).setCreativeTab(MysticalWorld.tab));

      event.addBlock(
          caminite_bricks = new BlockBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite_bricks").setModelCustom(true).setCreativeTab(MysticalWorld.tab));
      event.addBlock(
          caminite_bricks_stairs = new BlockStairsBase(caminite_bricks.getDefaultState(), SoundType.STONE, 2.0f, "caminite_bricks_stairs").setModelCustom(true)
              .setCreativeTab(MysticalWorld.tab));
      double_slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite_bricks_double_slab", caminite_bricks.getDefaultState(), true, null)
          .setModelCustom(true);
      slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "caminite_bricks_slab", caminite_bricks.getDefaultState(), false, double_slab_temp)
          .setModelCustom(true);
      double_slab_temp.setSlab(slab_temp);
      event.addBlock(caminite_bricks_slab = slab_temp.setCreativeTab(MysticalWorld.tab));
      event.addBlock(double_slab_temp);
      event.addBlock(caminite_bricks_wall = new BlockWallBase(caminite_bricks, SoundType.STONE, 2.0f, "caminite_bricks_wall").setModelCustom(true)
          .setCreativeTab(MysticalWorld.tab));
    }

    if (ConfigManager.modules.solarModuleEnabled) {
      //Solar
      event.addBlock(sunburnt_stone = new BlockBase(Material.ROCK, SoundType.STONE, 1.4f, "sunburnt_stone").setCreativeTab(MysticalWorld.tab));
      event.addBlock(
          sunburnt_stone_stairs = new BlockStairsBase(sunburnt_stone.getDefaultState(), SoundType.STONE, 2.0f, "sunburnt_stone_stairs").setModelCustom(true)
              .setCreativeTab(MysticalWorld.tab));
      double_slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "sunburnt_stone_double_slab", sunburnt_stone.getDefaultState(), true, null)
          .setModelCustom(true);
      slab_temp = new BlockSlabBase(Material.ROCK, SoundType.STONE, 2.0f, "sunburnt_stone_slab", sunburnt_stone.getDefaultState(), false, double_slab_temp)
          .setModelCustom(true);
      double_slab_temp.setSlab(slab_temp);
      event.addBlock(sunburnt_stone_slab = slab_temp.setCreativeTab(MysticalWorld.tab));
      event.addBlock(double_slab_temp);
      event.addBlock(sunburnt_stone_wall = new BlockWallBase(sunburnt_stone, SoundType.STONE, 2.0f, "sunburnt_stone_wall").setModelCustom(true)
          .setCreativeTab(MysticalWorld.tab));
    }
  }
}
