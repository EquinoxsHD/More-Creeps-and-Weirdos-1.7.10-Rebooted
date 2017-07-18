package equinoxs.mcw.render;

import org.lwjgl.opengl.GL11;

import equinoxs.mcw.entity.EntityG;
import equinoxs.mcw.models.ModelG;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class RenderG extends RenderLiving
{
	 protected ModelG modelBipedMain;

	    public RenderG(ModelG modelg, float f)
	    {
	        super(modelg, f);
	        modelBipedMain = modelg;
	    }

	    protected void fattenup(EntityG entityg, float f)
	    {
	        GL11.glScalef(entityg.modelsize, entityg.modelsize, entityg.modelsize);
	    }
	    protected void preRenderCallback(EntityLivingBase entityliving, float f)
	    {
	        fattenup((EntityG)entityliving, f);
	    }

	    protected ResourceLocation getEntityTexture(EntityG entity)
	    {
			return new ResourceLocation(entity.texture);
		}

		protected ResourceLocation getEntityTexture(Entity entity) {

			return getEntityTexture((EntityG) entity);
		}

}
