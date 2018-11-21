#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "7950eb316adf792283cac5743dfe5a11e74833dc"
LINUX_VERSION = "4.19.2"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux.git;protocol=https;branch=linux-4.19.y;name=meson \
           file://defconfig \
             \
             file://lima/0001-ARM-dts-add-gpu-node-to-exynos4.patch \
             file://lima/0002-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
             file://lima/0003-arm64-dts-add-switch-delay-for-meson-mali.patch \
             file://lima/0004-arm64-dts-add-switch-delay-for-meson-mali.patch \
             file://lima/0005-drm-lima-add-lima-uapi-header.patch \
             file://lima/0006-drm-lima-add-mali-4xx-GPU-hardware-regs.patch \
             file://lima/0007-drm-lima-add-lima-core-driver.patch \
             file://lima/0008-drm-lima-add-GPU-device-functions.patch \
             file://lima/0009-drm-lima-add-PMU-related-functions.patch \
             file://lima/0010-drm-lima-add-L2-cache-functions.patch \
             file://lima/0011-drm-lima-add-GP-related-functions.patch \
             file://lima/0012-drm-lima-add-PP-related-functions.patch \
             file://lima/0013-drm-lima-add-MMU-related-functions.patch \
             file://lima/0014-drm-lima-add-BCAST-related-function.patch \
             file://lima/0015-drm-lima-add-DLBU-related-functions.patch \
             file://lima/0016-drm-lima-add-GPU-virtual-memory-space-handing.patch \
             file://lima/0017-drm-lima-add-TTM-subsystem-functions.patch \
             file://lima/0018-drm-lima-add-buffer-object-functions.patch \
             file://lima/0019-drm-lima-add-GEM-related-functions.patch \
             file://lima/0020-drm-lima-add-GEM-Prime-related-functions.patch \
             file://lima/0021-drm-lima-add-GPU-schedule-using-DRM_SCHED.patch \
             file://lima/0022-drm-lima-add-context-related-functions.patch \
             file://lima/0023-drm-lima-add-makefile-and-kconfig.patch \
             file://lima/0024-drm-lima-use-SPDX-identifiers-and-change-copyright.patch \
             file://lima/0025-drm-lima-lima_reg.h-use-BIT.patch \
             file://lima/0026-drm-lima-add-IRQF_SHARED-for-GP-irq.patch \
             file://lima/0027-drm-lima-Kconfig-only-depend-on-ARM-or-ARM64.patch \
             file://lima/0028-drm-lima-add-comments-for-lima_reg.h.patch \
             file://lima/0029-drm-lima-wait-bo-fence-before-bo-close.patch \
             file://lima/0030-drm-lima-refine-lima_gem_sync_bo.patch \
             file://lima/0031-drm-lima-vm-will-be-freed-when-lima_sched_free_job.patch \
             file://lima/0032-drm-lima-vm-alloc-buffer-with-multi-page-table.patch \
             file://lima/0033-drm-lima-clear-vm-page-table-when-alloc.patch \
             file://lima/0034-drm-lima-update-SPDX-header-to-match-kernel-rules.patch \
             file://lima/0035-drm-fourcc-add-ARM-tiled-format-modifier.patch \
             file://lima/0036-drm-lima-add-DRM_LIMA_GEM_MOD-ioctl.patch \
             file://lima/0037-drm-lima-remove-depend-on-ARM-arch.patch \
             file://lima/0038-drm-lima-port-to-4.18-kernel.patch \
             file://lima/0039-drm-lima-user-can-choose-not-to-use-dlbu-on-mali450.patch \
             file://lima/0040-drm-lima-Fix-Lima-to-work-with-drm-scheduler-changes.patch \
             file://lima/0041-drm-lima-Fix-lima-cache-creation.patch \
             file://lima/0001-lima-PR20.patch \
             \
             file://overlay/0001-soc-amlogic-meson-gx-pwrc-vpu-fix-memory-power-up-do.patch \
             file://overlay/0002-dt-bindings-soc-amlogic-add-meson-canvas-documentati.patch \
             file://overlay/0003-soc-amlogic-add-meson-canvas-driver.patch \
             file://overlay/0004-ARM64-dts-meson-gx-add-dmcbus-and-canvas-nodes.patch \
             file://overlay/0005-drm-meson-Use-optional-canvas-provider.patch \
             file://overlay/0006-arm64-dts-meson-gx-Add-canvas-provider-node-to-the-v.patch \
             file://overlay/0007-drm-meson-Support-Overlay-plane-for-video-rendering.patch \
             file://overlay/0008-drm-meson-move-OSD-scaler-management-into-plane-atom.patch \
             file://overlay/0009-drm-meson-Add-primary-plane-scaling.patch \
             file://overlay/0010-drm-meson-Add-HDMI-1.4-4k-modes.patch \
             file://overlay/0011-drm-meson-Use-drm_fbdev_generic_setup.patch \
             file://overlay/0012-fixup-drm-meson-Use-optional-canvas-provider.patch \
             file://overlay/0013-drm-meson-Add-support-for-VIC-alternate-timings.patch \
             file://overlay/0014-drm-meson-add-support-for-1080p25-mode.patch \
             file://overlay/0015-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
             file://overlay/0016-drm-bridge-dw-hdmi-Add-SCDC-and-TMDS-Scrambling-supp.patch \
             file://overlay/0017-drm-meson-add-HDMI-div40-TMDS-mode.patch \
             file://overlay/0018-drm-meson-add-support-for-HDMI2.0-2160p-modes.patch \
             file://overlay/0019-drm-bridge-dw-hdmi-add-support-for-YUV420-output.patch \
             file://overlay/0020-drm-bridge-dw-hdmi-support-dynamically-get-input-out.patch \
             file://overlay/0021-drm-bridge-dw-hdmi-allow-ycbcr420-modes-for-0x200a.patch \
             file://overlay/0022-drm-meson-Add-YUV420-output-support.patch \
             file://overlay/0023-drm-meson-Output-in-YUV444-is-sink-supports-it.patch \
             file://overlay/0024-drm-meson-Add-implicit-fencing-support-for-primary-a.patch \
             file://overlay/e9b2ea418f40bcef8e4444265fba658373b1ca42.patch \
             \
             file://LE/0011-drm-meson-fix-max-height-width.patch \
             \
             file://v4l2/0005-dt-bindings-media-add-Amlogic-Video-Decoder-Bindings.patch \
             file://v4l2/0006-media-meson-add-v4l2-m2m-video-decoder-driver.patch \
             file://v4l2/0007-MAINTAINERS-Add-meson-video-decoder.patch \
             file://v4l2/0008-arm64-dts-meson-gx-add-vdec-entry.patch \
             file://v4l2/0009-arm64-dts-meson-add-vdec-entries.patch \
             file://v4l2/0010-meson-vdec-introduce-controls-and-V4L2_CID_MIN_BUFFE.patch \
             file://v4l2/0011-media-videodev2-add-V4L2_FMT_FLAG_NO_SOURCE_CHANGE.patch \
             file://v4l2/0012-meson-vdec-allow-subscribing-to-V4L2_EVENT_SOURCE_CH.patch \
             file://v4l2/0013-media-meson-vdec-add-H.264-decoding-support.patch \
             file://v4l2/0014-media-meson-vdec-add-MPEG4-decoding-support.patch \
             file://v4l2/0015-media-meson-vdec-add-MJPEG-decoding-support.patch \
             file://v4l2/0016-media-videodev2.h-Add-Amlogic-compressed-format.patch \
             file://v4l2/0017-media-meson-vdec-add-support-for-V4L2_PIX_FMT_AM21C.patch \
             file://v4l2/0018-media-meson-vdec-add-HEVC-decoding-support.patch \
             file://v4l2/0019-meson-vdec-more-debug-information-on-src-change.patch \
             file://v4l2/0020-meson-vdec-hevc-fix-conformance-window.patch \
             file://v4l2/0021-meson-vdec-hevc-simplify-integer-ceiling.patch \
             file://v4l2/0022-meson-vdec-hevc-various-80-line-fixes.patch \
             file://v4l2/0023-meson-vdec-hevc-fix-wrong-sao_up-buf-size.patch \
             file://v4l2/0024-meson-vdec-fix-coccinelle-warnings.patch \
             file://v4l2/0025-meson-vdec-make-amvdec_dst_buf_done_offset-public.patch \
             file://v4l2/0026-meson-vdec-hevc-support-offset-based-frame-DONE-ing.patch \
             file://v4l2/0027-meson-vdec-don-t-allow-dropping-timestamps-with-hevc.patch \
             \
             file://LE/0013-ASoC-meson-add-meson-audio-core-driver.patch \
             file://LE/0014-ASoC-meson-add-register-definitions.patch \
             file://LE/0015-ASoC-meson-add-aiu-i2s-dma-support.patch \
             file://LE/0016-ASoC-meson-add-initial-i2s-dai-support.patch \
             file://LE/0017-ASoC-meson-add-aiu-spdif-dma-support.patch \
             file://LE/0018-ASoC-meson-add-initial-spdif-dai-support.patch \
             file://LE/0020-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
             file://LE/0021-snd-meson-activate-HDMI-audio-path.patch \
             file://LE/0022-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
             file://LE/0023-ARM64-dts-meson-gx-add-sound-dai-cells-to-HDMI-node.patch \
             file://LE/0024-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
             file://LE/0025-drm-bridge-dw-hdmi-Use-AUTO-CTS-setup-mode-when-non-.patch \
             file://LE/0026-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
             file://LE/0046-ASoC-hdmi-codec-fix-channel-allocation.patch \
             file://LE/0047-drm-dw-hdmi-i2s-add-.get_eld-callback-for-ALSA-SoC.patch \
             file://LE/0048-drm-dw-hdmi-i2s-add-multi-channel-lpcm-support.patch \
             file://LE/0049-drm-dw-hdmi-call-hdmi_set_cts_n-after-clock-is-enabl.patch \
             file://LE/0050-drm-dw-hdmi-extract-dw_hdmi_connector_update_edid.patch \
             file://LE/0051-drm-dw-hdmi-update-edid-on-hpd-event.patch \
             file://LE/0052-fix.patch \
             file://LE/0001-ARM64-DT-meson-gx-increase-CMA-size-for-UHD-decode.patch \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

# Checksum changed on 4.17
LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"

