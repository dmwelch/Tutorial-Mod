package org.coderdojoia.tutorialmod;

import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;

public class ItemClinkerMix extends Item {
	private static final String name = "clinker_mix";
	
	public ItemClinkerMix() {
		this.setUnlocalizedName(TutorialMod.MODID + "_" + name);
		this.setCreativeTab(CreativeTabs.tabMisc);
		this.setTextureName(TutorialMod.MODID + ':' + name);
	}
}
