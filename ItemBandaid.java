package equinoxs.mcw.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBandaid extends Item
{
	private int healAmount;
	
	public ItemBandaid()
	{
		super();
		healAmount = 4;
		maxStackSize = 24;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		if(entityplayer.getHealth() < 20)
		{
			world.playSoundAtEntity(entityplayer, "mcw:bandaid", 1.0F, 1.0F);
			itemstack.stackSize--;
			entityplayer.heal(healAmount);
		}
		
		return itemstack;
	}

}
