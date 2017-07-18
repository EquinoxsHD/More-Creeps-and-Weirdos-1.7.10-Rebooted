package equinoxs.mcw.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class ItemBattery extends Item
{
	private int healAmount;
	
	public ItemBattery()
	{
		super();
		maxStackSize = 16;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		world.playSoundAtEntity(entityplayer, "mcw:spark", 1.0F, 1.0F);
		entityplayer.attackEntityFrom(DamageSource.inFire, 1.0F);
		return itemstack;
	}

}
