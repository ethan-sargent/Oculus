package net.irisshaders.iris.shadows.frustum.fallback;

import net.irisshaders.iris.shadows.frustum.BoxCuller;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix4f;

public class BoxCullingFrustum extends Frustum {
	private final BoxCuller boxCuller;
	private double x, y, z;
	private int worldMinYDH;
	private int worldMaxYDH;

	public BoxCullingFrustum(BoxCuller boxCuller) {
		super(new Matrix4f(), new Matrix4f());

		this.boxCuller = boxCuller;
	}

	public void prepare(double cameraX, double cameraY, double cameraZ) {
		this.x = cameraX;
		this.y = cameraY;
		this.z = cameraZ;
		boxCuller.setPosition(cameraX, cameraY, cameraZ);
	}

	// For Immersive Portals
	// NB: The shadow culling in Immersive Portals must be disabled, because when Advanced Shadow Frustum Culling
	//     is not active, we are at a point where we can make no assumptions how the shader pack uses the shadow
	//     pass beyond what it already tells us. So we cannot use any extra fancy culling methods.
	public boolean canDetermineInvisible(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		return false;
	}

	public boolean isVisible(AABB box) {
		return !boxCuller.isCulled(box);
	}
}
