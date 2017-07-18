package equinoxs.mcw;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.world.biome.BiomeGenBase;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import equinoxs.mcw.entity.EntityG;
import equinoxs.mcw.entity.EntityMummy;
import equinoxs.mcw.entity.EntityRobotTed;
import equinoxs.mcw.entity.EntityRobotTodd;
import equinoxs.mcw.items.ITemGGPigRadio;
import equinoxs.mcw.items.ItemArmsword;
import equinoxs.mcw.items.ItemArmyGem;
import equinoxs.mcw.items.ItemAtom;
import equinoxs.mcw.items.ItemBabyJarEmpty;
import equinoxs.mcw.items.ItemBabyJarFull;
import equinoxs.mcw.items.ItemBandaid;
import equinoxs.mcw.items.ItemBattery;
import equinoxs.mcw.items.ItemBlorpCola;
import equinoxs.mcw.items.ItemCavemanClub;
import equinoxs.mcw.items.ItemCoolRanchDoritos;
import equinoxs.mcw.items.ItemDonut;
import equinoxs.mcw.items.ItemEvilEgg;
import equinoxs.mcw.items.ItemExtinguisher;
import equinoxs.mcw.items.ItemFrisbee;
import equinoxs.mcw.items.ItemGem1;
import equinoxs.mcw.items.ItemGem2;
import equinoxs.mcw.items.ItemGem3;
import equinoxs.mcw.items.ItemGem4;
import equinoxs.mcw.items.ItemGem5;
import equinoxs.mcw.items.ItemGemSword;
import equinoxs.mcw.items.ItemGooDonut;
import equinoxs.mcw.items.ItemGrowRay;
import equinoxs.mcw.items.ItemGun;
import equinoxs.mcw.items.ItemGun2;
import equinoxs.mcw.items.ItemLifeGem;
import equinoxs.mcw.items.ItemLolly;
import equinoxs.mcw.items.ItemLovePotion;
import equinoxs.mcw.items.ItemMedicine;
import equinoxs.mcw.items.ItemMobilePhone;
import equinoxs.mcw.items.ItemMoney;
import equinoxs.mcw.items.ItemNachoCheezeDoritos;
import equinoxs.mcw.items.ItemPeeBucket;
import equinoxs.mcw.items.ItemPopsicle;
import equinoxs.mcw.items.ItemRadio;
import equinoxs.mcw.items.ItemRam16k;
import equinoxs.mcw.items.ItemRayGun;
import equinoxs.mcw.items.ItemRocket;
import equinoxs.mcw.items.ItemShrinkRay;
import equinoxs.mcw.items.a_rockmonster;

/*
 * Main reason of me doing this is for my dad, he's always there and always is there for me through thick and thin, all I want to say is Thank you to him! I really appreciate what you do for me.
 * I love you dad.
 */
@Mod(modid = "mcw", name = "More Creeps and Weirdos++", version = "2.1")
public class MoreCreepsAndWeirdos
{
	
	public static MoreCreepsAndWeirdos modInstance;
	
	//Items
	public static Item itemBlorpCola;
	public static Item itemMoney;
	public static Item itemDonut;
	public static Item itemGooDonut;
	public static Item itemRayGun;
	public static Item itemBandaid;
	public static Item itemBattery;
	public static Item itemNachoCheezeDoritos;
	public static Item itemCoolRanchDoritos;
	public static Item itemRam16k;
	public static Item itemLolly;
	public static Item itemPopsicle;
	public static Item itemGrowRay;
	public static Item itemShrinkRay;
	public static Item itemMedicine;
	public static Item itemMobilePhone;
	public static Item itemRocket;
	public static Item itemEvilEgg;
	public static Item itemArmsword;
	public static Item itemBabyJarEmpty;
	public static Item itemBabyJarFull;
	public static Item itemCavemanClub;
	public static Item itemExtinguisher;
	public static Item itemFrisbee;
	public static Item itemArmyGem;
	public static Item itemAtom;
	public static Item itemGem1;
	public static Item itemGem2;
	public static Item itemGem3;
	public static Item itemGem4;
	public static Item itemGem5;
	public static Item itemGemSword;
	public static Item itemGGPigRadio;
	public static Item itemLifeGem;
	public static Item itemPeeBucket;
	public static Item itemRadio;
	public static Item itemLovePotion;
	public static Item itemGun;
	public static Item itemGun2;
	
	public static Item a_rockmonster;
	

	private int aX;

	private int aY;

	
	
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event){
		//Item and Block Init
		//Config
		//Achievement Labels
		a_rockmonster = new a_rockmonster().setUnlocalizedName("a_rockmonster").setTextureName("mcw:a-rockmonster");
		
		
		//Items
		itemBlorpCola = new ItemBlorpCola().setUnlocalizedName("ItemBlorpCola").setTextureName("mcw:itemblorpcola").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemMoney = new ItemMoney().setUnlocalizedName("ItemMoney").setTextureName("mcw:itemmoney").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemDonut = new ItemDonut().setUnlocalizedName("ItemDonut").setTextureName("mcw:itemdonut").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGooDonut = new ItemGooDonut().setUnlocalizedName("ItemGooDonut").setTextureName("mcw:itemgoodonut").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemRayGun = new ItemRayGun().setUnlocalizedName("ItemRayGun").setTextureName("mcw:itemraygun").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemNachoCheezeDoritos = new ItemFood(15, 0.5F, false).setUnlocalizedName("ItemNachoCheezeDoritos").setTextureName("mcw:itemnachocheezedoritos").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemCoolRanchDoritos = new ItemFood(15, 0.5F, false).setUnlocalizedName("ItemCoolRanchDoritos").setTextureName("mcw:itemcoolranchdoritos").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemBandaid = new ItemBandaid().setUnlocalizedName("ItemBandaid").setTextureName("mcw:itembandaid").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemBattery = new ItemBattery().setUnlocalizedName("ItemBattery").setTextureName("mcw:itembattery").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemRam16k = new ItemRam16k().setUnlocalizedName("ItemRam16k").setTextureName("mcw:itemram16k").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemLolly = new ItemLolly().setUnlocalizedName("ItemLolly").setTextureName("mcw:itemlolly").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemPopsicle = new ItemPopsicle().setUnlocalizedName("ItemPopsicle").setTextureName("mcw:itempopsicle").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGrowRay = new ItemGrowRay().setUnlocalizedName("ItemGrowRay").setTextureName("mcw:itemgrowray").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemShrinkRay = new ItemShrinkRay().setUnlocalizedName("ItemShrinkRay").setTextureName("mcw:itemshrinkray").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemMedicine = new ItemMedicine().setUnlocalizedName("ItemMedicine").setTextureName("mcw:itemmedicine").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemMobilePhone = new ItemMobilePhone().setUnlocalizedName("ItemMobilePhone").setTextureName("mcw:itemmobilephone").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemRocket = new ItemRocket().setUnlocalizedName("ItemRocket").setTextureName("mcw:itemrocket").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemEvilEgg = new ItemEvilEgg().setUnlocalizedName("ItemEvilEgg").setTextureName("mcw:itemevilegg").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemArmsword = new ItemArmsword().setUnlocalizedName("ItemArmsword").setTextureName("mcw:itemarmsword").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemBabyJarEmpty = new ItemBabyJarEmpty().setUnlocalizedName("ItemBabyJarEmpty").setTextureName("mcw:itembabyjarempty").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemBabyJarFull = new ItemBabyJarFull().setUnlocalizedName("ItemBabyJarFull").setTextureName("mcw:itembabyjarfull").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemCavemanClub = new ItemCavemanClub().setUnlocalizedName("ItemCavemanClub").setTextureName("mcw:itemcavemanclub").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemExtinguisher = new ItemExtinguisher().setUnlocalizedName("ItemExtinguisher").setTextureName("mcw:itemextinguisher").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemFrisbee = new ItemFrisbee().setUnlocalizedName("ItemFrisbee").setTextureName("mcw:itemfrisbee").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemArmyGem = new ItemArmyGem().setUnlocalizedName("ItemArmyGem").setTextureName("mcw:itemarmygem").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGem1 = new ItemGem1().setUnlocalizedName("ItemGem1").setTextureName("mcw:itemgem1").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGem2 = new ItemGem2().setUnlocalizedName("ItemGem2").setTextureName("mcw:itemgem2").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGem3 = new ItemGem3().setUnlocalizedName("ItemGem3").setTextureName("mcw:itemgem3").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGem4 = new ItemGem4().setUnlocalizedName("ItemGem4").setTextureName("mcw:itemgem4").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGem5 = new ItemGem5().setUnlocalizedName("ItemGem5").setTextureName("mcw:itemgem4").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGemSword = new ItemGemSword().setUnlocalizedName("ItemGemSword").setTextureName("mcw:itemgemsword").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGGPigRadio = new ITemGGPigRadio().setUnlocalizedName("ItemGGPigRadio").setTextureName("mcw:itemggpigradio").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemLifeGem = new ItemLifeGem().setUnlocalizedName("ItemLifeGem").setTextureName("mcw:itemlifegem").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemPeeBucket = new ItemPeeBucket().setUnlocalizedName("ItemPeeBucket").setTextureName("mcw:itempeebucket").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemRadio = new ItemRadio().setUnlocalizedName("ItemRadio").setTextureName("mcw:itemradio").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemLovePotion = new ItemLovePotion().setUnlocalizedName("ItemLovePotion").setTextureName("mcw:itemlovepotion").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGun = new ItemGun().setUnlocalizedName("ItemGun").setTextureName("mcw:itemgun").setCreativeTab(tabMoreCreepsAndWeirdos);
		itemGun2 = new ItemGun2().setUnlocalizedName("ItemGun2").setTextureName("mcw:itemgun2");
		itemAtom = new ItemAtom().setUnlocalizedName("ItemAtom").setTextureName("mcw:itematom").setCreativeTab(tabMoreCreepsAndWeirdos);
		
		//Items Registry
		GameRegistry.registerItem(itemBlorpCola, itemBlorpCola.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMoney, itemMoney.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemDonut, itemDonut.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGooDonut, itemGooDonut.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRayGun, itemRayGun.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBandaid, itemBandaid.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBattery, itemBattery.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRam16k, itemRam16k.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLolly, itemLolly.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemPopsicle, itemPopsicle.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGrowRay, itemGrowRay.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemNachoCheezeDoritos, itemNachoCheezeDoritos.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCoolRanchDoritos, itemCoolRanchDoritos.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemShrinkRay, itemShrinkRay.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMedicine, itemMedicine.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemMobilePhone, itemMobilePhone.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRocket, itemRocket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemEvilEgg, itemEvilEgg.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemArmsword, itemArmsword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBabyJarEmpty, itemBabyJarEmpty.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemBabyJarFull, itemBabyJarFull.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemCavemanClub, itemCavemanClub.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemExtinguisher, itemExtinguisher.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemFrisbee, itemFrisbee.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGem1, itemGem1.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGem2, itemGem2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGem3, itemGem3.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGem4, itemGem4.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGem5, itemGem5.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGemSword, itemGemSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGGPigRadio, itemGGPigRadio.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLifeGem, itemLifeGem.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemPeeBucket, itemPeeBucket.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemRadio, itemRadio.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemLovePotion, itemLovePotion.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGun, itemGun.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemGun2, itemGun2.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(itemAtom, itemAtom.getUnlocalizedName().substring(5));
		
		 

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		addMob(EntityG.class, "G", Config.g_ID, Config.sg, 1, 4, EnumCreatureType.creature, allBiomes());
		addMob(EntityMummy.class, "Mummy", Config.mummy_ID, Config.smummy, 1, 4, EnumCreatureType.creature, allBiomes());
		addMob(EntityRobotTodd.class, "RobotTodd", Config.robottodd_ID, Config.srobottodd, 1, 4, EnumCreatureType.creature, allBiomes());
	}
		public void addMob(Class <? extends EntityLiving> classz, String name, int id, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes)
		{
			EntityRegistry.registerGlobalEntityID(classz, name, EntityRegistry.findGlobalUniqueEntityId(), 0x000000, 0xFFFFFF);
			EntityRegistry.registerModEntity(classz, name, id, this, 40, 1, true);
			if(weightedProb > 0)
			{
				EntityRegistry.addSpawn(classz, weightedProb, min, max, typeOfCreature, biomes);
			}
		}
		public BiomeGenBase[] allBiomes()
		{
			return new BiomeGenBase[] {
					BiomeGenBase.plains, 
					BiomeGenBase.desert, 
					BiomeGenBase.extremeHills, 
					BiomeGenBase.forest, 
					BiomeGenBase.taiga, 
					BiomeGenBase.swampland, 
					BiomeGenBase.icePlains, 
					BiomeGenBase.iceMountains, 
					BiomeGenBase.beach, 
					BiomeGenBase.desertHills, 
					BiomeGenBase.forestHills, 
					BiomeGenBase.taigaHills, 
					BiomeGenBase.extremeHillsEdge,
					BiomeGenBase.jungle,
					BiomeGenBase.stoneBeach
				};
		}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public static CreativeTabs tabMoreCreepsAndWeirdos = new CreativeTabs("tabMoreCreepsAndWeirdos"){
		@Override
		public Item getTabIconItem(){
			return new ItemStack(itemBlorpCola).getItem();
		}
	};

}

//The reason i'm making this mod if because of my dad. He's been there for me through everything and this is my way to say thanks. Thanks dad :)
//Thanks For Watching! Please Leave A Like and Comment! It would be amazing if you would subscribe!! See Ya