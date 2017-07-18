package equinoxs.mcw.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemLolly extends Item
{
	private int healAmount;
	
	public ItemLolly()
	{
		super();
		healAmount = 2;
		maxStackSize = 32;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.playSoundAtEntity(entityplayer, "mcw:lolly", 1.0F, 1.0F);
		itemstack.stackSize--;
		entityplayer.heal(healAmount);
		return itemstack;
		
	}

}
