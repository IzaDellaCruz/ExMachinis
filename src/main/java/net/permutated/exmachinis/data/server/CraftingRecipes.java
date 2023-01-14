package net.permutated.exmachinis.data.server;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.permutated.exmachinis.ModRegistry;
import novamachina.exnihilosequentia.common.init.ExNihiloItems;

import java.util.function.Consumer;

public class CraftingRecipes extends RecipeProvider {
    public CraftingRecipes(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(ModRegistry.GOLD_UPGRADE.get())
            .pattern("tct")
            .pattern("gdg")
            .pattern("ggg")
            .define('t', Items.CYAN_TERRACOTTA)
            .define('c', Tags.Items.DYES_GREEN)
            .define('d', Tags.Items.INGOTS_GOLD)
            .define('g', Tags.Items.GLASS)
            .unlockedBy("has_gold_ingot", has(Tags.Items.INGOTS_GOLD))
            .save(consumer);

        ShapedRecipeBuilder.shaped(ModRegistry.DIAMOND_UPGRADE.get())
            .pattern("nun")
            .pattern("nun")
            .pattern("nun")
            .define('u', ModRegistry.GOLD_UPGRADE.get())
            .define('n', Tags.Items.GEMS_DIAMOND)
            .unlockedBy("has_diamond", has(Tags.Items.GEMS_DIAMOND))
            .save(consumer);

        ShapedRecipeBuilder.shaped(ModRegistry.NETHERITE_UPGRADE.get())
            .pattern("nun")
            .pattern("nun")
            .pattern("nun")
            .define('u', ModRegistry.DIAMOND_UPGRADE.get())
            .define('n', Tags.Items.INGOTS_NETHERITE)
            .unlockedBy("has_netherite_ingot", has(Tags.Items.INGOTS_NETHERITE))
            .save(consumer);

        var sieveTag = TagKey.create(ForgeRegistries.ITEMS.getRegistryKey(), new ResourceLocation("exnihilosequentia:sieves"));
        ShapedRecipeBuilder.shaped(ModRegistry.FLUX_SIEVE_ITEM.get())
            .pattern("bbb")
            .pattern("bsb")
            .pattern("ihi")
            .define('b', Items.IRON_BARS)
            .define('s', sieveTag)
            .define('i', Tags.Items.STORAGE_BLOCKS_IRON)
            .define('h', Items.HOPPER)
            .unlockedBy("has_sieve", has(sieveTag))
            .save(consumer);

        var hammerItem = ExNihiloItems.HAMMER_DIAMOND.get();
        ShapedRecipeBuilder.shaped(ModRegistry.FLUX_HAMMER_ITEM.get())
            .pattern("ggg")
            .pattern("gdg")
            .pattern("ihi")
            .define('g', Tags.Items.GLASS_PANES)
            .define('d', hammerItem)
            .define('i', Tags.Items.STORAGE_BLOCKS_IRON)
            .define('h', Items.HOPPER)
            .unlockedBy("has_diamond_hammer", has(hammerItem))
            .save(consumer);

        ShapedRecipeBuilder.shaped(ModRegistry.FLUX_COMPACTOR_ITEM.get())
            .pattern("ipi")
            .pattern("pcp")
            .pattern("ihi")
            .define('i', Tags.Items.STORAGE_BLOCKS_IRON)
            .define('p', Items.PISTON)
            .define('c', Items.COMPARATOR)
            .define('h', Items.HOPPER)
            .unlockedBy("has_anvil", has(Items.ANVIL))
            .save(consumer);

        var crucibleItem = ExNihiloItems.CRUCIBLE_FIRED.get();
        ShapedRecipeBuilder.shaped(ModRegistry.FLUX_CRUCIBLE_ITEM.get())
            .pattern("bbb")
            .pattern("bdb")
            .pattern("ihi")
            .define('b', Items.BRICKS)
            .define('d', crucibleItem)
            .define('i', Tags.Items.STORAGE_BLOCKS_IRON)
            .define('h', Items.HOPPER)
            .unlockedBy("has_crucible", has(crucibleItem))
            .save(consumer);
    }

}
