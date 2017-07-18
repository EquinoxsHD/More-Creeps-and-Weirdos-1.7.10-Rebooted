package equinoxs.mcw;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Config {
	
	public static int srobottodd;
	public static int sblorp;
	public static int sg;
	public static int srobotted;
	public static int smummy;
	
	private static boolean unlimitedSpawn;
	
	public static int robottodd_ID;
	public static int blorp_ID;
	public static int g_ID;
	public static int robotted_ID;
	public static int mummy_ID;
	

	
	
	public static void preInit(FMLPreInitializationEvent event){
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		String spawnNbr = "Spawn Number";
		String entityID = "Entity";
		String mobProperty = "Mob Property";
		String itemProperty = "Item Property";
		String worldGen = "World Gen";
		String worldGenRarity = "World Gen Rarity";
		try {
			config.load();
			unlimitedSpawn = config.get("Spawn", "Unlimited spawn length", false, "Once activated, you can set what value you want for mob spawning.").getBoolean();
			 srobottodd = config.get(spawnNbr, "Robot Todd", 8).getInt();
			
			 ////////////////////////////////////////////////////////////
			 robottodd_ID = config.get(entityID, "Robot Todd Entity ID", 970).getInt();
			
		
			 
			 
			 
			 config.save();
		} finally{
			if(config.hasChanged())
			{
				config.save();
			}
		}
		Config.applySpawnLimit();
	}
	
	public static void applySpawnLimit()
	{
		 if (srobottodd < 0 || srobottodd > 12)
	        {
	            srobottodd = 7;
	        }
	}

}
