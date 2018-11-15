# Enable lima for meson
PACKAGECONFIG_append_meson-gx = " gallium"
PACKAGECONFIG_remove_meson-gx = " vulkan"
GALLIUMDRIVERS_meson-gx = "meson,lima,freedreno,etnaviv,swrast,imx,rockchip,sun4i"
DRIDRIVERS_meson-gx = ""
