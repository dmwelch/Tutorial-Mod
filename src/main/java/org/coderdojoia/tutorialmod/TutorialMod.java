package org.coderdojoia.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import org.coderdojoia.tutorialmod.*; /*BlockConcrete;
import org.coderdojoia.tutorialmod.BlockClinker;
import org.coderdojoia.tutorialmod.BlockLimestone;
import org.coderdojoia.tutorialmod.ItemCementDry;
import org.coderdojoia.tutorialmod.ItemClinkerMix;
*/
@Mod(modid = TutorialMod.MODID, version = TutorialMod.VERSION, name="tutorialmod")
public class TutorialMod
{
    public static final String MODID = "tutorialmod";
    public static final String VERSION = "1.0";
    public static Block limestone;
    public static Item clinker_mix;
    public static Block clinker;
    public static Item cement_mix;
    public static Block concrete;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	limestone = new BlockLimestone();	
    	GameRegistry.registerBlock(limestone, "Limestone");
    	clinker_mix = new ItemClinkerMix();
    	GameRegistry.registerItem(clinker_mix, "Clinker Mix");
    	clinker = new BlockClinker();
    	GameRegistry.registerBlock(clinker, "Clinker");
    	cement_mix = new ItemCementMix();  // dropped when clinker broken (neglecting gypsum)
    	GameRegistry.registerItem(cement_mix, "Cement Mix");
    	concrete = new BlockConcrete();
    	GameRegistry.registerBlock(concrete, "Concrete");	    
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	/*
    	 * Let's create some recipes for concrete:
    	 *   1) shapeless recipe: limestone + clay = 2 clinker_mix
    	 *   2) smelting recipe: clinker_mix -> 2 clinker  //TODO: Clinker doesn't drop cement_mix
    	 *   3) shapeless recipe: 8 cement + water + sand + gravel = 4 concrete
    	 *   4) shaped recipe (3x3): 'checkerboard' of cobblestone (5) and concrete (4) = 9 reinforced wall
    	 */
    	ItemStack clinkerMixInput1 = new ItemStack(limestone, 1);
    	ItemStack clinkerMixInput2 = new ItemStack(Blocks.clay, 1);
    	ItemStack clinkerMixOutput = new ItemStack(clinker_mix, 2);
        GameRegistry.addShapelessRecipe(clinkerMixOutput, clinkerMixInput1, clinkerMixInput2);  // #1
        
        float clinkerXP = 0.12F;  // cobblestone == 0.1F, diamond ore == 1.0F
        GameRegistry.addSmelting(clinker_mix, new ItemStack(clinker, 2), clinkerXP);  // #2
        
        ItemStack concreteInput1 = new ItemStack(cement_mix, 8);
        ItemStack concreteInput2 = new ItemStack(Blocks.sand, 1);
        ItemStack concreteInput3 = new ItemStack(Blocks.gravel, 1);
        ItemStack concreteInput4 = new ItemStack(Items.water_bucket, 1);
    	ItemStack concreteOutput = new ItemStack(concrete, 8);
        GameRegistry.addShapelessRecipe(concreteOutput, concreteInput1, concreteInput2, concreteInput3, concreteInput4);  // #3
        
        ItemStack shapedOutput = new ItemStack(Blocks.cobblestone_wall, 9);  //TODO: reinforced wall
        GameRegistry.addRecipe(shapedOutput,
        	"X-X", 
        	"-X-", 
        	"X-X", 
        	'X', Blocks.cobblestone, 
        	'-', concrete  //TODO: wet_cement
        );  // #4
        
        /*
         * -- Example of a 2x2 recipe --
         * ItemStack shaped2x2Output = new ItemStack(concrete, 4);
         * GameRegistry.addRecipe(shaped2x2Output,
         *    	"D ",
         *      " D", 
         *     	'D', Blocks.cobblestone);
         */
        
        /* -- Example of an enchantment recipe --
         * ItemStack OPickaxe = new ItemStack(Items.iron_pickaxe);
         * OPickaxe.addEnchantment(Enchantment.silkTouch, 1);    
         * OPickaxe.addEnchantment(Enchantment.efficiency, 127);   
         * GameRegistry.addShapelessRecipe(OPickaxe, Items.iron_pickaxe, Items.stick);
         */
        }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
    	System.out.println("Tutorial postInit");
    }
}
