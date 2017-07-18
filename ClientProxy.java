package equinoxs.mcw.proxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.SideOnly;
import equinoxs.mcw.entity.EntityG;
import equinoxs.mcw.entity.EntityRobotTodd;
import equinoxs.mcw.models.ModelG;
import equinoxs.mcw.models.ModelRobotTodd;
import equinoxs.mcw.other.TickClientHandlerEvent;
import equinoxs.mcw.render.RenderG;
import equinoxs.mcw.render.RenderRobotTodd;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy
{
	public void render()
	{
		MinecraftForge.EVENT_BUS.register(new TickClientHandlerEvent());
		RenderingRegistry.registerEntityRenderingHandler(EntityG.class, new RenderG(new ModelG(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityRobotTodd.class, new RenderRobotTodd(new ModelRobotTodd(), 0.5F));
	}

}
