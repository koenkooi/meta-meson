#
# Linux Support for 64bit Amlogic Meson SoCs
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}-${PV}:"

SRCREV_meson = "29dcea88779c856c7dc92040a0c01233263101d4"
LINUX_VERSION = "4.17.0"
	
# Linux stable tree
SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/torvalds/linux.git;protocol=https;name=meson \
           file://0001-WIP-Overlay.patch \
           file://0002-WIP-fixups.patch \
           file://0003-More-fixes.patch \
           file://0004-meson-overlay-deal-with-drm_atomic_helper_check_plan.patch \
           file://0005-libretech-cc-disable-CVBS-connector.patch \
           file://0006-ARM64-dts-meson-gxbb-add-sound-dai-cells-to-HDMI-nod.patch \
           file://0007-ASoC-hdmi-codec-fix-channel-allocation.patch \
           file://0008-drm-dw-hdmi-i2s-add-.get_eld-callback-for-ALSA-SoC.patch \
           file://0009-drm-dw-hdmi-i2s-add-multi-channel-lpcm-support.patch \
           file://0010-drm-meson-Call-drm_crtc_vblank_on-drm_crtc_vblank_of.patch \
           file://0011-drm-meson-select-dw-hdmi-i2s-audio-for-meson-hdmi.patch \
           file://0012-ASoC-meson-add-meson-audio-core-driver.patch \
           file://0013-ASoC-meson-add-register-definitions.patch \
           file://0014-ASoC-meson-add-aiu-i2s-dma-support.patch \
           file://0015-ASoC-meson-add-initial-i2s-dai-support.patch \
           file://0016-snd-meson-activate-HDMI-audio-path.patch \
           file://0017-ARM64-defconfig-add-CONFIG_MESON_EFUSE.patch \
           file://0018-ARM64-defconfig-enable-CEC-support.patch \
           file://0019-ARM64-defconfig-enable-audio-support-for-meson-SoCs-.patch \
           file://0020-ARM64-dts-meson-gx-add-audio-controller-nodes.patch \
           file://0021-ARM64-dts-meson-gxl-add-sound-dai-cells-to-HDMI-node.patch \
           file://0022-ARM64-dts-meson-activate-hdmi-audio-HDMI-enabled-boa.patch \
           file://0023-ath10k-add-inlined-wrappers-for-htt-tx-ops.patch \
           file://0024-ath10k-add-inlined-wrappers-for-htt-rx-ops.patch \
           file://0025-ath10k-add-struct-ath10k_bus_params.patch \
           file://0026-ath10k-high_latency-detection.patch \
           file://0027-ath10k-add-bus-type-check-in-ath10k_init_hw_params.patch \
           file://0028-ath10k-per-target-config-of-max_num_peers.patch \
           file://0029-ath10k-DMA-related-fixes-for-high-latency-devices.patch \
           file://0030-ath10k-various-fixes-for-high-latency-devices.patch \
           file://0031-ath10k-add-start_once-support.patch \
           file://0032-ath10k-add-HTT-TX-HL-ops.patch \
           file://0033-ath10k-add-HTT-RX-HL-ops.patch \
           file://0034-ath10k-htt-RX-ring-config-HL-support.patch \
           file://0035-ath10k-htt-High-latency-TX-support.patch \
           file://0036-ath10k-htt-High-latency-RX-support.patch \
           file://0037-ath10k-wmi-disable-softirq-s-while-calling-ieee80211.patch \
           file://0038-ath10k-remove-htt-pending-TX-count-for-high-latency.patch \
           file://0039-ath10k-add-QCA9377-usb-hw_param-item.patch \
           file://0040-ath10k-add-QCA9377-sdio-hw_param-item.patch \
           file://0041-ath10k_sdio-sdio-htt-data-transfer-fixes.patch \
           file://0042-ath10k_sdio-wb396-reference-card-fix.patch \
           file://0043-ath10k_sdio-DMA-bounce-buffers-for-read-write.patch \
           file://0044-ath10k_sdio-reduce-transmit-msdu-count.patch \
           file://0045-ath10k_sdio-use-clean-packet-headers.patch \
           file://0046-ath10k_sdio-high-latency-fixes-for-beacon-buffer.patch \
           file://0047-ath10k_sdio-fix-rssi-indication.patch \
           file://0048-ath10k_sdio-common-read-write.patch \
           file://0049-ath10k_sdio-virtual-scatter-gather-for-receive.patch \
           file://0050-ath10k_sdio-hif-start-once-addition.patch \
           file://0051-ath10k-sdio-fix-type-mismatch-in-func-prototype.patch \
           file://0052-ath10k-usb-add-sparklan-usb-support.patch \
           file://0053-ARM-dts-add-gpu-node-to-exynos4.patch \
           file://0054-dt-bindings-add-switch-delay-property-for-mali-utgar.patch \
           file://0055-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0056-arm64-dts-add-switch-delay-for-meson-mali.patch \
           file://0057-drm-lima-add-lima-uapi-header.patch \
           file://0058-drm-lima-add-mali-4xx-GPU-hardware-regs.patch \
           file://0059-drm-lima-add-lima-core-driver.patch \
           file://0060-drm-lima-add-GPU-device-functions.patch \
           file://0061-drm-lima-add-PMU-related-functions.patch \
           file://0062-drm-lima-add-L2-cache-functions.patch \
           file://0063-drm-lima-add-GP-related-functions.patch \
           file://0064-drm-lima-add-PP-related-functions.patch \
           file://0065-drm-lima-add-MMU-related-functions.patch \
           file://0066-drm-lima-add-BCAST-related-function.patch \
           file://0067-drm-lima-add-DLBU-related-functions.patch \
           file://0068-drm-lima-add-GPU-virtual-memory-space-handing.patch \
           file://0069-drm-lima-add-TTM-subsystem-functions.patch \
           file://0070-drm-lima-add-buffer-object-functions.patch \
           file://0071-drm-lima-add-GEM-related-functions.patch \
           file://0072-drm-lima-add-GEM-Prime-related-functions.patch \
           file://0073-drm-lima-add-GPU-schedule-using-DRM_SCHED.patch \
           file://0074-drm-lima-add-context-related-functions.patch \
           file://0075-drm-lima-add-makefile-and-kconfig.patch \
           file://0076-drm-lima-use-SPDX-identifiers-and-change-copyright.patch \
           file://0077-drm-lima-lima_reg.h-use-BIT.patch \
           file://0078-drm-lima-add-IRQF_SHARED-for-GP-irq.patch \
           file://0079-drm-lima-Kconfig-only-depend-on-ARM-or-ARM64.patch \
           file://0080-drm-lima-add-comments-for-lima_reg.h.patch \
           file://0081-drm-lima-wait-bo-fence-before-bo-close.patch \
           file://0082-drm-lima-refine-lima_gem_sync_bo.patch \
           file://0083-drm-lima-vm-will-be-freed-when-lima_sched_free_job.patch \
           file://0084-drm-lima-vm-alloc-buffer-with-multi-page-table.patch \
           file://0085-drm-lima-clear-vm-page-table-when-alloc.patch \
           file://0086-drm-lima-update-SPDX-header-to-match-kernel-rules.patch \
           file://0001-fix-audio-picked-from-LE-slack.patch \
           \
           file://ely/0001-clock-meson8b-add-clocks-necessary-for-VDEC1.patch;patch=1 \
           file://ely/0002-soc-meson-add-power-controller-for-vdec.patch;patch=1 \
           file://ely/0003-media-meson-add-V4L2-M2M-video-decoder.patch;patch=1 \
           file://ely/0004-ARM-dts-meson8b-add-video-decoder-pwrc-entry.patch;patch=1 \
           file://ely/0005-Add-the-H.264-vdec-firmware.patch;patch=1 \
           file://ely/0006-media-meson-vdec-Many-fixes-stability-updates.patch;patch=1 \
           file://ely/0007-media-meson-vdec-Change-capture-pixfmt-to-V4L2_PIX_F.patch;patch=1 \
           file://ely/0008-media-meson-vdec-Many-fixes-stability-updates-2.patch;patch=1 \
           file://ely/0009-media-meson-vdec-Map-vb2-buffers-to-the-canvases-mor.patch;patch=1 \
           file://ely/0010-media-meson-vdec-the-H.264-vdec-is-now-usable-on-s80.patch;patch=1 \
           file://ely/0011-meson-gxl-add-vdec-support.patch;patch=1 \
           file://ely/0012-meson-vdec-several-fixups-for-gstreamer-compat.patch;patch=1 \
           file://ely/0013-meson-vdec-Rewrite-design.patch;patch=1 \
           file://ely/0014-meson-vdec-Add-forgotten-H.264-ref-MV-alloc.patch;patch=1 \
           file://ely/0015-meson-gxl-vdec-Bump-VDEC_1-clock-to-648MHz.patch;patch=1 \
           file://ely/0016-meson-vdec-Actually-output-NV12M.patch;patch=1 \
           file://ely/0017-meson-vdec-Fix-multiple-DMA-leaks.patch;patch=1 \
           file://ely/0018-meson-vdec-Initial-HEVC-WIP.-Fully-broken.patch;patch=1 \
           file://ely/0019-meson-vdec-add-MPEG-1-2-support.patch;patch=1 \
           file://ely/0020-meson-vdec-h264-remove-post-canvas.patch;patch=1 \
           file://ely/0021-meson-vdec-esparser-Fix-VIFIFO-end-bound.patch;patch=1 \
           file://ely/0022-meson-vdec-h264-Fix-SEI-data-handling.patch;patch=1 \
           file://ely/0023-dts-Actually-set-VDEC_1-clock-to-666MHz.patch;patch=1 \
           file://ely/0024-mseon-vdec-Minor-improvements-to-HEVC.patch;patch=1 \
           file://ely/0025-meson-vdec-Add-MPEG4-2-H.263-support.patch;patch=1 \
           file://ely/0026-Remove-duplicate-HEVC-V4L2-pixfmt.patch;patch=1 \
           file://ely/0027-meson-vdec-Rework-the-input-output-logic.patch;patch=1 \
           file://ely/0028-meson-vdec-esparser-Don-t-stall-on-input.patch;patch=1 \
           file://ely/0029-meson-vdec-Limit-input-buffers-to-17.patch;patch=1 \
           file://ely/0030-meson-vdec-hevc-Fetch-and-process-RPM.patch;patch=1 \
           file://ely/0031-meson-vdec-h264-Increase-the-minimum-amount-of-buffe.patch;patch=1 \
           file://ely/0032-dts-meson-gxbb-add-vdec-entries.patch;patch=1 \
           file://ely/0033-meson-vdec-fix-crash-on-module-remove.patch;patch=1 \
           file://ely/0034-Fix-clocks-following-rebase.patch;patch=1 \
           file://ely/0035-meson-vdec-hevc-push-current-progress.patch;patch=1 \
           file://ely/0036-meson-vdec-hevc-Fix-a-really-really-dumb-mistake.patch;patch=1 \
           file://ely/0037-meson-vdec-per-soc-compatible-list.patch;patch=1 \
           file://ely/0038-meson-vdec-hevc-First-working-initial-support.patch;patch=1 \
           file://ely/0039-meson-vdec-hevc-update-to-the-latest-firmware.patch;patch=1 \
           file://ely/0040-meson-vdec-hevc-enable-mcrcc.patch;patch=1 \
           file://ely/0041-meson-vdec-General-updates.patch;patch=1 \
           file://ely/0042-meson-vdec-HEVC-General-updates.patch;patch=1 \
           \
           file://defconfig \
           "

KERNEL_VERSION_SANITY_SKIP="1"

KERNEL_CLASSES = "kernel-uimage-meson"

LINUX_VERSION_EXTENSION_append = "-meson64"

require linux-meson.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=bbea815ee2795b2f4230826c0c6b8814"
