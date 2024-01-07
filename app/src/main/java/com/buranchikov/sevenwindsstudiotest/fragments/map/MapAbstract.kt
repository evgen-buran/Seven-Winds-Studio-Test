package com.buranchikov.sevenwindsstudiotest.fragments.map

import com.yandex.mapkit.Animation
import com.yandex.mapkit.ScreenRect
import com.yandex.mapkit.geometry.Geometry
import com.yandex.mapkit.geometry.geo.Projection
import com.yandex.mapkit.images.ImageUrlProvider
import com.yandex.mapkit.layers.GeoObjectTapListener
import com.yandex.mapkit.layers.Layer
import com.yandex.mapkit.layers.LayerOptions
import com.yandex.mapkit.layers.TileFormat
import com.yandex.mapkit.logo.Logo
import com.yandex.mapkit.map.CameraBounds
import com.yandex.mapkit.map.CameraListener
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.GeoObjectSelectionMetadata
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.map.Map
import com.yandex.mapkit.map.MapLoadedListener
import com.yandex.mapkit.map.MapObjectCollection
import com.yandex.mapkit.map.MapType
import com.yandex.mapkit.map.VisibleRegion
import com.yandex.mapkit.tiles.TileProvider
import com.yandex.mapkit.tiles.UrlProvider

abstract class MapAbstract:Map {
    override fun getCameraPosition(): CameraPosition {
        TODO("Not yet implemented")
    }

    override fun cameraPosition(p0: Geometry): CameraPosition {
        TODO("Not yet implemented")
    }

    override fun cameraPosition(p0: Geometry, p1: ScreenRect): CameraPosition {
        TODO("Not yet implemented")
    }

    override fun cameraPosition(
        p0: Geometry,
        p1: Float,
        p2: Float,
        p3: ScreenRect?
    ): CameraPosition {
        TODO("Not yet implemented")
    }

    override fun getVisibleRegion(): VisibleRegion {
        TODO("Not yet implemented")
    }

    override fun visibleRegion(p0: CameraPosition): VisibleRegion {
        TODO("Not yet implemented")
    }

    override fun move(p0: CameraPosition, p1: Animation, p2: Map.CameraCallback?) {
        TODO("Not yet implemented")
    }

    override fun move(p0: CameraPosition) {
        TODO("Not yet implemented")
    }

    override fun getCameraBounds(): CameraBounds {
        TODO("Not yet implemented")
    }

    override fun addLayer(
        p0: String,
        p1: TileFormat,
        p2: LayerOptions,
        p3: TileProvider,
        p4: ImageUrlProvider,
        p5: Projection
    ): Layer {
        TODO("Not yet implemented")
    }

    override fun addLayer(
        p0: String,
        p1: TileFormat,
        p2: LayerOptions,
        p3: UrlProvider,
        p4: ImageUrlProvider,
        p5: Projection
    ): Layer {
        TODO("Not yet implemented")
    }

    override fun isNightModeEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setNightModeEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isZoomGesturesEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setZoomGesturesEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isScrollGesturesEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setScrollGesturesEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isTiltGesturesEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setTiltGesturesEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isRotateGesturesEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setRotateGesturesEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun isFastTapEnabled(): Boolean {
        TODO("Not yet implemented")
    }

    override fun setFastTapEnabled(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getMapType(): MapType {
        TODO("Not yet implemented")
    }

    override fun setMapType(p0: MapType) {
        TODO("Not yet implemented")
    }

    override fun addInputListener(p0: InputListener) {
        TODO("Not yet implemented")
    }

    override fun removeInputListener(p0: InputListener) {
        TODO("Not yet implemented")
    }

    override fun addCameraListener(p0: CameraListener) {
        TODO("Not yet implemented")
    }

    override fun removeCameraListener(p0: CameraListener) {
        TODO("Not yet implemented")
    }

    override fun setMapLoadedListener(p0: MapLoadedListener?) {
        TODO("Not yet implemented")
    }

    override fun getMapObjects(): MapObjectCollection {
        TODO("Not yet implemented")
    }

    override fun addTapListener(p0: GeoObjectTapListener) {
        TODO("Not yet implemented")
    }

    override fun removeTapListener(p0: GeoObjectTapListener) {
        TODO("Not yet implemented")
    }

    override fun deselectGeoObject() {
        TODO("Not yet implemented")
    }

    override fun selectGeoObject(p0: GeoObjectSelectionMetadata) {
        TODO("Not yet implemented")
    }

    override fun getLogo(): Logo {
        TODO("Not yet implemented")
    }

    override fun getPoiLimit(): Int? {
        TODO("Not yet implemented")
    }

    override fun setPoiLimit(p0: Int?) {
        TODO("Not yet implemented")
    }

    override fun setMapStyle(p0: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun setMapStyle(p0: Int, p1: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun resetMapStyles() {
        TODO("Not yet implemented")
    }

    override fun set2DMode(p0: Boolean) {
        TODO("Not yet implemented")
    }

    override fun projection(): Projection {
        TODO("Not yet implemented")
    }

    override fun wipe() {
        TODO("Not yet implemented")
    }

    override fun isValid(): Boolean {
        TODO("Not yet implemented")
    }
}