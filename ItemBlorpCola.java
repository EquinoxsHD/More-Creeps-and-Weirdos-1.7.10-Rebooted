package equinoxs.mcw.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBlorpCola extends Item
{
	private int healAmount;
	
	public ItemBlorpCola()
	{
		super();
		healAmount = 2;
		maxStackSize = 24;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		entityplayer.swingItem();
		world.playSoundAtEntity(entityplayer, "mcw:blorpcola", 1.0F, 1.0F);
		itemstack.stackSize--;
		
		entityplayer.heal(healAmount);
		return itemstack;
	}

}
