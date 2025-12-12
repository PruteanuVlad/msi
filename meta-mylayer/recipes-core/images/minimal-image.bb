DESCRIPTION = "A minimal Yocto image"
LICENSE = "MIT"

# Inherit the base image class
inherit core-image

# Basic packages for a minimal image
IMAGE_INSTALL = "packagegroup-core-boot nano bandit-bait"

# Optional: reduce size further
EXTRA_IMAGE_FEATURES = " \
    ssh-server-dropbear \
"

# Minimal filesystem
IMAGE_FSTYPES = "tar.bz2"

