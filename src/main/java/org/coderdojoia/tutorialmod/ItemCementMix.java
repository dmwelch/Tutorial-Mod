package org.coderdojoia.tutorialmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemCementMix extends Item {
	private static final String name = "cement_mix";
	//private static BlockClinker clinker = new BlockClinker();
	
	public ItemCementMix() {
		this.setUnlocalizedName(TutorialMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setTextureName(TutorialMod.MODID + ':' + name);
		//this.getItemFromBlock(clinker);
	}

}
