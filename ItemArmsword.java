package equinoxs.mcw.items;

import java.util.Random;

import com.jcraft.jorbis.Block;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ItemArmsword extends ItemSword
{
	public static Random random = new Random();
	
	public ItemArmsword()
	{
		super(ToolMaterial.EMERALD);
		setMaxDamage(64);
	}
	
	public int getDamageVsEnitty(Entity entity)
	{
		return 5;
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		return itemstack;
	}
	
	public float getStrVsBlock(ItemStack itemstack, Block block)
	{
		return 3F;
	}
	
	public boolean hitEntity(ItemStack itemstack, EntityLiving entityliving, EntityLiving entityliving1)
	{
		itemstack.damageItem(1, entityliving1);
		return true;
	}
	
	public boolean onBlockDestroyed(ItemStack itemstack, int i, int j, int k, int l, EntityLiving entityliving)
	{
		itemstack.damageItem(2, entityliving);
		return true;
	}
	
	public boolean isFull3D()
	{
		return true;
	}
	
	public boolean canHarvestBlock(Block block)
	{
		return false;
	}

}


