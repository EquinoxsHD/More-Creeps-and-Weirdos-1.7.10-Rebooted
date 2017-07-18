package equinoxs.mcw.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPopsicle extends Item
{
	private int healAmount;
	
	public ItemPopsicle()
	{
		super();
		healAmount = 4;
		maxStackSize = 16;
		
	}
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.eat;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		entityplayer.swingItem();
		world.playSoundAtEntity(entityplayer, "mcw:lick", 1.0F, 1.0F);
		itemstack.stackSize--;
		entityplayer.heal(healAmount);
		return itemstack;
		
	}

}
