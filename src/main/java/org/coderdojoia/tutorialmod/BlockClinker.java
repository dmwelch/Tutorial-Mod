package org.coderdojoia.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockClinker extends Block {
	private static final String name = "clinker";
	
	public BlockClinker()
	{
		super(Material.coral);
		this.setBlockName(TutorialMod.MODID + "_" + name);
		this.setBlockTextureName(TutorialMod.MODID + ":" + name);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(0.2F);
		this.setResistance(0.2F);
		this.setStepSound(soundTypeGravel);
		this.setHarvestLevel("pickaxe", 0);
	}
}
