#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

# tag: v4.16.1
SRCREV_meson="b42b71cd28f213cf4688b9891e66b57bdb6eefe8"
LINUX_VERSION ?= "4.16.4"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=https;branch=linux-4.16.y;name=meson \
           file://0001-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0002-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0003-drm-meson-Add-support-for-DMT-modes-on-HDMI.patch \
           file://0004-drm-bridge-dw-hdmi-Fix-overflow-workaround-for-Amlog.patch \
           file://0005-media-rc-meson-ir-add-timeout-on-idle.patch \
           file://0006-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0007-ASoC-meson-add-register-definitions.patch \
           file://0008-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0009-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0010-snd-meson-activate-HDMI-audio-path.patch \
           file://0011-usb-dwc3-of-simple-add-support-for-shared-and-pulsed.patch \
           file://0012-usb-dwc3-of-simple-add-support-for-the-Amlogic-Meson.patch \
           file://0013-usb-add-a-flag-to-skip-PHY-initialization-to-struct-.patch \
           file://0014-usb-core-add-a-wrapper-for-the-USB-PHYs-on-the-HCD.patch \
           file://0015-usb-core-hcd-integrate-the-PHY-wrapper-into-the-HCD-.patch \
           file://0016-usb-host-xhci-mtk-remove-custom-USB-PHY-handling.patch \
           file://0017-usb-host-ehci-platform-remove-custom-USB-PHY-handlin.patch \
           file://0018-usb-host-ohci-platform-remove-custom-USB-PHY-handlin.patch \
           file://0019-usb-core-hcd-remove-support-for-initializing-a-singl.patch \
           file://0020-phy-amlogic-phy-meson-gxl-usb2-support-the-clock-and.patch \
           file://0021-phy-amlogic-phy-meson-gxl-usb2-default-to-host-mode.patch \
           file://0022-phy-amlogic-phy-meson-gxl-usb2-don-t-log-an-error-on.patch \
           file://0023-phy-amlogic-phy-meson-gxl-usb2-rename-some-of-the-U2.patch \
           file://0024-phy-amlogic-add-USB3-PHY-support-for-Meson-GXL-and-G.patch \
           file://0025-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0026-ARM64-defconfig-enable-CEC-support.patch \
           file://0027-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0028-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0029-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0030-ARM64-dts-meson-gx-Add-HDMI_5V-regulator-on-selected.patch \
           file://0031-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0032-ARM64-dts-meson-bump-mali450-clk-to-744MHz.patch \
           file://0033-ARM64-dts-meson-gxl-add-USB-host-support.patch \
           file://0034-ARM64-dts-meson-gxm-add-GXM-specific-USB-host-config.patch \
           file://0035-ARM64-dts-meson-gxl-s905x-p212-enable-the-USB-contro.patch \
           file://0036-ARM64-dts-meson-gx-p23x-q20x-enable-the-USB-controll.patch \
           file://0037-ARM64-dts-meson-gxl-s905x-libretech-cc-enable-the-US.patch \
           file://0038-ARM64-dts-meson-gxl-nexbox-a95x-enable-the-USB-contr.patch \
           file://0039-ARM64-dts-meson-gxm-khadas-vim2-enable-the-USB-contr.patch \
           file://defconfig \
           file://0001-clock-meson8b-add-clocks-necessary-for-VDEC1.patch \
           file://0002-soc-meson-add-power-controller-for-vdec.patch \
           file://0003-media-meson-add-V4L2-M2M-video-decoder.patch \
           file://0004-ARM-dts-meson8b-add-video-decoder-pwrc-entry.patch \
           file://0005-Add-the-H.264-vdec-firmware.patch \
           file://0006-media-meson-vdec-Many-fixes-stability-updates.patch \
           file://0007-media-meson-vdec-Change-capture-pixfmt-to-V4L2_PIX_F.patch \
           file://0008-media-meson-vdec-Many-fixes-stability-updates-2.patch \
           file://0009-media-meson-vdec-Map-vb2-buffers-to-the-canvases-mor.patch \
           file://0010-media-meson-vdec-the-H.264-vdec-is-now-usable-on-s80.patch \
           file://0011-meson-gxl-add-vdec-support.patch \
           file://0012-meson-vdec-several-fixups-for-gstreamer-compat.patch \
           file://0013-meson-vdec-Rewrite-design.patch \
           file://0014-meson-vdec-Add-forgotten-H.264-ref-MV-alloc.patch \
           file://0015-meson-gxl-vdec-Bump-VDEC_1-clock-to-648MHz.patch \
           file://0016-meson-vdec-Actually-output-NV12M.patch \
           file://0017-meson-vdec-Fix-multiple-DMA-leaks.patch \
           file://0001-meson-vdec-Initial-HEVC-WIP.-Fully-broken.patch \
           file://0002-meson-vdec-add-MPEG-1-2-support.patch \
           file://0003-meson-vdec-h264-remove-post-canvas.patch \
           file://0004-meson-vdec-esparser-Fix-VIFIFO-end-bound.patch \
           file://0005-meson-vdec-h264-Fix-SEI-data-handling.patch \
           file://0006-dts-Actually-set-VDEC_1-clock-to-666MHz.patch \
           file://0007-mseon-vdec-Minor-improvements-to-HEVC.patch \
           file://0008-meson-vdec-Add-MPEG4-2-H.263-support.patch \
           file://0010-meson-vdec-Rework-the-input-output-logic.patch \
           file://0011-meson-vdec-esparser-Don-t-stall-on-input.patch \
           file://0012-meson-vdec-Limit-input-buffers-to-17.patch \
           file://0013-meson-vdec-hevc-Fetch-and-process-RPM.patch \
           file://0001-meson-vdec-h264-Increase-the-minimum-amount-of-buffe.patch \
           file://0002-dts-meson-gxbb-add-vdec-entries.patch \
           file://0003-meson-vdec-fix-crash-on-module-remove.patch \
           file://0004-meson-vdec-hevc-push-current-progress.patch \
           file://0005-meson-vdec-hevc-Fix-a-really-really-dumb-mistake.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc
