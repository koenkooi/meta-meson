SUMMARY = "Firmware for amlogic vdec"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README.md;md5=3507eb41a5ce7a52df41943f4528ce28"

inherit allarch

SRC_URI = "git://github.com/chewitt/meson-firmware.git;protocol=https"
SRCREV = "0db131d984855b377d9cf61ff2dd1b4c6c2e9dca"

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}${nonarch_base_libdir}/firmware/
	cp -a ${S}/meson ${D}${nonarch_base_libdir}/firmware/ 
}

FILES_${PN} = "${nonarch_base_libdir}"
