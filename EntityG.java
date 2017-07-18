package equinoxs.mcw.entity;

import equinoxs.mcw.MoreCreepsAndWeirdos;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityG extends EntityMob
{
	 public float modelsize;
	    public String texture;

	    public EntityG(World world)
	    {
	        super(world);
	        texture = "mcw:textures/entity/g.png";
	        setSize(width * 2.0F, height * 2.5F);
	        modelsize = 2.0F;
	        this.getNavigator().setBreakDoors(true);
	        this.tasks.addTask(0, new EntityAISwimming(this));
	        this.tasks.addTask(2, new EntityG.AIAttackEntity());
	        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 0.5D));
	        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
	        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
	        this.tasks.addTask(8, new EntityAILookIdle(this));
	        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 1, true));
	    }
	    
	    protected void applyEntityAttributes()
	    {
	        super.applyEntityAttributes();
	        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(70);
	        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.45D);
	        this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(2D);
	    }

	    /**
	     * (abstract) Protected helper method to write subclass entity data to NBT.
	     */
	    public void writeEntityToNBT(NBTTagCompound nbttagcompound)
	    {
	        super.writeEntityToNBT(nbttagcompound);
	        nbttagcompound.setFloat("ModelSize", modelsize);
	    }

	    /**
	     * (abstract) Protected helper method to read subclass entity data from NBT.
	     */
	    public void readEntityFromNBT(NBTTagCompound nbttagcompound)
	    {
	        super.readEntityFromNBT(nbttagcompound);
	        modelsize = nbttagcompound.getFloat("ModelSize");
	    }

	    /**
	     * Called when the entity is attacked.
	     */
	    public boolean attackEntityFrom(DamageSource damagesource, float i)
	    {
	        Entity entity = damagesource.getEntity();

	        if (entity != null)
	        {
	            double d = -MathHelper.sin((entity.rotationYaw * (float)Math.PI) / 180F);
	            double d1 = MathHelper.cos((entity.rotationYaw * (float)Math.PI) / 180F);
	            motionX = d * 11D;
	            motionZ = d1 * 11D;
	        }

	        return super.attackEntityFrom(DamageSource.causeMobDamage(this), i);
	    }

	    protected void attackEntity(Entity entity, float f)
	    {
	        if (onGround)
	        {
	            double d = entity.posX - posX;
	            double d2 = entity.posZ - posZ;
	            float f1 = MathHelper.sqrt_double(d * d + d2 * d2);
	            motionX = (d / (double)f1) * 0.40000000000000002D * 0.50000000192092897D + motionX * 0.18000000098023225D;
	            motionZ = (d2 / (double)f1) * 0.40000000000000002D * 0.37000000192092897D + motionZ * 0.18000000098023225D;
	            motionY = 0.15000000019604645D;
	        }

	        if ((double)f < 6D)
	        {
	            double d1 = entity.posX - posX;
	            double d3 = entity.posZ - posZ;
	            float f2 = MathHelper.sqrt_double(d1 * d1 + d3 * d3);
	            motionX = (d1 / (double)f2) * 0.40000000000000002D * 0.40000000192092894D + motionX * 0.18000000098023225D;
	            motionZ = (d3 / (double)f2) * 0.40000000000000002D * 0.27000000192092893D + motionZ * 0.18000000098023225D;
	            rotationPitch = 90F;
	        }
	    }
	    
	    class AIAttackEntity extends EntityAIBase
	    {
			@Override
			public boolean shouldExecute() {
				return EntityG.this.getAttackTarget() != null;
			}
			
			public void updateTask()
			{
				try{
				float f = EntityG.this.getDistanceToEntity(getAttackTarget());
				if(f < 256F)
				{
					attackEntity(EntityG.this.getAttackTarget(), f);
					EntityG.this.getLookHelper().setLookPositionWithEntity(EntityG.this.getAttackTarget(), 10.0F, 10.0F);
					EntityG.this.getNavigator().clearPathEntity();
					EntityG.this.getMoveHelper().setMoveTo(EntityG.this.getAttackTarget().posX, EntityG.this.getAttackTarget().posY, EntityG.this.getAttackTarget().posZ, 0.5D);
				}
				if(f < 2F)
				{
					EntityG.this.attackEntityAsMob(EntityG.this.getAttackTarget());
				}
				}
				catch (NullPointerException ex)
				{
				ex.printStackTrace();
				}
			}
	    }
	    
	    /**
	     * Checks if the entity's current position is a valid location to spawn this entity.
	     */
	    public boolean getCanSpawnHere()
	    {
	        int i = MathHelper.floor_double(posX);
	        int j = MathHelper.floor_double(getBoundingBox().minY);
	        int k = MathHelper.floor_double(posZ);
	        Block i1 = worldObj.getBlock(i, j - 1, k);
	        int j1 = worldObj.countEntities(EntityMummy.class);
	        return i1 != Blocks.sand && i1 != Blocks.cobblestone && i1 != Blocks.log && i1 != Blocks.double_stone_slab && i1 != Blocks.stone_slab && i1 != Blocks.planks && i1 != Blocks.wool && worldObj.getCollidingBoundingBoxes(this, getBoundingBox()).size() == 0 && rand.nextInt(15) == 0 && j1 < 5;
	    }

	    /**
	     * Plays living's sound at its position
	     */
	    public void playLivingSound()
	    {
	        String s = getLivingSound();

	        if (s != null)
	        {
	            worldObj.playSoundAtEntity(this, s, getSoundVolume(), (rand.nextFloat() - rand.nextFloat()) * 0.2F + 1.0F + (2.0F - modelsize) * 2.0F);
	        }
	    }

	    /**
	     * Will return how many at most can spawn in a chunk at once.
	     */
	    public int getMaxSpawnedInChunk()
	    {
	        return 1;
	    }

	    /**
	     * Returns the sound this mob makes while it's alive.
	     */
	    protected String getLivingSound()
	    {
	        return "mcw:g";
	    }

	    /**
	     * Returns the sound this mob makes when it is hurt.
	     */
	    protected String getHurtSound()
	    {
	        return "mcw:ghurt";
	    }

	    /**
	     * Returns the sound this mob makes on death.
	     */
	    protected String getDeathSound()
	    {
	        return "mcw:gdeath";
	    }

	    /**
	     * Called when the mob's health reaches 0.
	     */
	    public void onDeath(DamageSource damagesource)
	    {
	    	if(!worldObj.isRemote)
	    	{
	    		int maxitems = 0;
	            if (rand.nextInt(200) == 98)
	            {
	                dropItem(Item.getItemFromBlock(Blocks.gold_block), 1);
	                maxitems++;
	            }
	            if (rand.nextInt(5) == 0)
	            {
	                dropItem(Items.gold_ingot, rand.nextInt(2) + 1);
	                maxitems++;
	            }
	            if (rand.nextInt(150) > 145)
	            {
	                dropItem(Items.golden_sword, 1);
	                maxitems++;
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            		{
	                		dropItem(Items.golden_pickaxe, 1);
	                		maxitems++;
	            		}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.golden_shovel, 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.golden_axe, 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.golden_helmet, 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.golden_chestplate, 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.golden_boots, 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 80)
	            	{
	            		dropItem(Items.wheat, rand.nextInt(6) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Item.getItemFromBlock(Blocks.glass), rand.nextInt(6) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(MoreCreepsAndWeirdos.itemGooDonut, rand.nextInt(3) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 88)
	            	{
	            		dropItem(Item.getItemFromBlock(Blocks.grass), rand.nextInt(6) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Item.getItemFromBlock(Blocks.glowstone), rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.glowstone_dust, rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.glass_bottle, rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.gold_nugget, rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) == 88)
	            	{
	            		dropItem(Items.golden_apple, rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) > 98)
	            	{
	            		dropItem(Items.gunpowder, rand.nextInt(2) + 1);
	            		maxitems++;
	            	}
	            }
	            if (maxitems < 3){
	            	if (rand.nextInt(100) == 88)
	            	{
	            		dropItem(Items.ghast_tear, rand.nextInt(2) + 1);
	            	}
	            }
	    	}
	        super.onDeath(damagesource);
	    }

}
