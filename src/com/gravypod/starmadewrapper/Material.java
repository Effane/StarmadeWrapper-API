package com.gravypod.starmadewrapper;

import com.gravypod.starmadewrapper.plugins.material.MaterialData;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public enum Material {

    CORE(1),
    POWER(2),
    SHIELD(3),
    SALVAGE_CONTROLLER(4),
    HULL_COLOR_GREY(5),
    WEAPON_CONTROLLER(6),
    DOCK(7),
    THRUSTER(8),
    WEAPON(16),
    DEATHSTAR_CORE(65),
    GLASS(63),
    EXPLOSIVE(14),
    RADAR_JAMMING(15),
    CLOAKING(22),
    SALVAGE(24),
    MISSILE_DUMB_CONTROLLER(38),
    MISSILE_DUMB(32),
    MISSILE_HEAT_CONTROLLER(46),
    MISSILE_HEAT(40),
    MISSILE_FAFO_CONTROLLER(54),
    MISSILE_FAFO(48),
    GRAVITY(56),
    REPAIR(30),
    REPAIR_CONTROLLER(39),
    COCKPIT(47),
    LIGHT(55),
    LIGHT_BEACON(62),
    TERRAIN_ICE(64),
    LANDING_ELEMENT(112),
    LIFT_ELEMENT(113),
    RECYCLER_ELEMENT(114),
    STASH_ELEMENT(120),
    AI_ELEMENT(121),
    DOOR_ELEMENT(122),
    BUILD_BLOCK(123),
    TERRAIN_LAVA(80),
    TERRAIN_EXOGEN(128),
    TERRAIN_OCTOGEN(129),
    TERRAIN_QUANTAGEN(130),
    TERRAIN_QUANTANIUM(131),
    TERRAIN_PLEXTANIUM(132),
    TERRAIN_ORANGUTANIUM(133),
    TERRAIN_SUCCUMITE(134),
    TERRAIN_CENOMITE(135),
    TERRAIN_AWESOMITE(136),
    TERRAIN_VAPPECIDE(137),
    TERRAIN_MARS_TOP(138),
    TERRAIN_MARS_ROCK(139),
    TERRAIN_MARS_DIRT(140),
    TERRAIN_MARS_TOP_ROCK(141),
    TERRAIN_EXTRANIUM(72),
    TERRAIN_ROCK(73),
    TERRAIN_SAND(74),
    TERRAIN_EARTH_TOP_DIRT(82),
    TERRAIN_EARTH_TOP_ROCK(83),
    TERRAIN_TREE_TRUNK(84),
    TERRAIN_TREE_LEAF(85),
    TERRAIN_WATER(86),
    TERRAIN_DIRT(87),
    DOCKING_ENHANCER(88),
    TERRAIN_CACTUS(89),
    TERRAIN_PURPLE_ALIEN_TOP(90),
    TERRAIN_PURPLE_ALIEN_ROCK(91),
    TERRAIN_PURPLE_ALIEN_VINE(92),
    TERRAIN_GRASS_SPRITE(93),
    PLAYER_SPAWN_MODULE(94),
    TERRAIN_BROWNWEED_SPRITE(95),
    TERRAIN_MARSTENTACLES_SPRITE(96),
    TERRAIN_ALIENVINE_SPRITE(97),
    TERRAIN_GRASSFLOWERS_SPRITE(98),
    TERRAIN_LONGWEED_SPRITE(99),
    TERRAIN_TALLSHROOM_SPRITE(100),
    TERRAIN_PURSPIRE_SPRITE(101),
    TERRAIN_TALLGRASSFLOWERS_SPRITE(102),
    TERRAIN_MINICACTUS_SPRITE(103),
    TERRAIN_REDSHROOM_SPRITE(104),
    TERRAIN_PURPTACLES_SPRITE(105),
    TERRAIN_TALLFLOWERS_SPRITE(106),
    TERRAIN_ROCK_SPRITE(107),
    TERRAIN_ALIENFLOWERS_SPRITE(108),
    TERRAIN_YHOLE_SPRITE(109),
    TERRAIN_M1L2(142),
    TERRAIN_M1L3(143),
    TERRAIN_M1L4(144),
    TERRAIN_M1L5(145),
    TERRAIN_M2L2(146),
    TERRAIN_M2L3(147),
    TERRAIN_M2L4(148),
    TERRAIN_M2L5(149),
    TERRAIN_M3L2(150),
    TERRAIN_M3L3(151),
    TERRAIN_M3L4(152),
    TERRAIN_M3L5(153),
    TERRAIN_M4L2(154),
    TERRAIN_M4L3(155),
    TERRAIN_M4L4(156),
    TERRAIN_M4L5(157),
    TERRAIN_M5L2(158),
    TERRAIN_M5L3(159),
    TERRAIN_M5L4(160),
    TERRAIN_M5L5(161),
    TERRAIN_M6L2(162),
    TERRAIN_M6L3(163),
    TERRAIN_M6L4(164),
    TERRAIN_M6L5(165),
    TERRAIN_M7L2(166),
    TERRAIN_M7L3(167),
    TERRAIN_M7L4(168),
    TERRAIN_M7L5(169),
    TERRAIN_M8L2(170),
    TERRAIN_M8L3(171),
    TERRAIN_M8L4(172),
    TERRAIN_M8L5(173),
    TERRAIN_M9L2(174),
    TERRAIN_M9L3(175),
    TERRAIN_M9L4(176),
    TERRAIN_M9L5(177),
    TERRAIN_M10L2(178),
    TERRAIN_M10L3(179),
    TERRAIN_M10L4(180),
    TERRAIN_M10L5(181),
    TERRAIN_M11L2(182),
    TERRAIN_M11L3(183),
    TERRAIN_M11L4(184),
    TERRAIN_M11L5(185),
    TERRAIN_M12L2(186),
    TERRAIN_M12L3(187),
    TERRAIN_M12L4(188),
    TERRAIN_M12L5(189),
    TERRAIN_M13L2(190),
    TERRAIN_M13L3(191),
    TERRAIN_M13L4(192),
    TERRAIN_M13L5(193),
    TERRAIN_M14L2(194),
    TERRAIN_M14L3(195),
    TERRAIN_M14L4(196),
    TERRAIN_M14L5(197),
    TERRAIN_M15L2(198),
    TERRAIN_M15L3(199),
    TERRAIN_M15L4(200),
    TERRAIN_M15L5(201),
    TERRAIN_M16L2(202),
    TERRAIN_M16L3(203),
    TERRAIN_M16L4(204),
    TERRAIN_M16L5(205),
    TERRAIN_NEGACIDE(206),
    TERRAIN_QUANTACIDE(207),
    TERRAIN_NEGAGATE(208),
    TERRAIN_METATE(209),
    TERRAIN_INSANIUM(210),
    FACTORY_INPUT(211),
    FACTORY_INPUT_ENH(212),
    FACTORY_POWER_CELL(213),
    FACTORY_POWER_CELL_ENH(214),
    FACTORY_POWER_COIL(215),
    FACTORY_POWER_COIL_ENH(216),
    FACTORY_POWER_BLOCK(217),
    FACTORY_POWER_BLOCK_ENH(218),
    POWER_CELL(219),
    POWER_COIL(220),
    UNUSED_TEST(221),
    FACTORY_PARTICLE_PRESS(222),
    MAN_SD1000_CAP(223),
    MAN_SD2000_CAP(224),
    MAN_SD3000_CAP(225),
    MAN_SD1000_FLUX(226),
    MAN_SD2000_FLUX(227),
    MAN_SD3000_FLUX(228),
    MAN_SD1000_MICRO(229),
    MAN_SD2000_MICRO(230),
    MAN_SD3000_MICRO(231),
    MAN_SD1000_DELTA(232),
    MAN_SD2000_DELTA(233),
    MAN_SD3000_DELTA(234),
    MAN_SD1000_MEM(235),
    MAN_SD2000_MEM(236),
    MAN_SD3000_MEM(237),
    MAN_SDPROTON(238),
    MAN_RED(239),
    MAN_PURP(240),
    MAN_BROWN(241),
    MAN_GREEN(242),
    MAN_YELLOW(243),
    MAN_BLACK(244),
    MAN_WHITE(245),
    MAN_BLUE(246),
    MAN_P1000B(247),
    MAN_P2000B(248),
    MAN_P3000B(249),
    MAN_P10000A(250),
    MAN_P20000A(251),
    MAN_P30000A(252),
    MAN_P40000A(253),
    MAN_YHOLE_NUC(254),
    FACTORY_SD10000(255),
    FACTORY_SD20000(256),
    FACTORY_SD30000(257),
    FACTORY_SDADV(258),
    FACTORY_SD1000(259),
    FACTORY_SD2000(260),
    FACTORY_SD3000(261),
    FACTORY_MINERAL(262),
    MAN_GLASS_BOTTLE(272),
    MAN_SCIENCE_BOTTLE(273),
    TERRAIN_ICEPLANET_SURFACE(274),
    TERRAIN_ICEPLANET_ROCK(275),
    TERRAIN_ICEPLANET_WOOD(276),
    TERRAIN_ICEPLANET_LEAVES(277),
    TERRAIN_ICEPLANET_SPIKE_SPRITE(278),
    TERRAIN_ICEPLANET_ICECRAG_SPRITE(279),
    TERRAIN_ICEPLANET_ICECORAL_SPRITE(280),
    TERRAIN_ICEPLANET_ICEGRASS_SPRITE(281),
    LIGHT_RED(282),
    LIGHT_BLUE(283),
    LIGHT_GREEN(284),
    LIGHT_YELLOW(285),
    TERRAIN_ICEPLANET_CRYSTAL(286),
    TERRAIN_REDWOOD(287),
    TERRAIN_REDWOOD_LEAVES(288),
    FIXED_DOCK(289),
    FIXED_DOCK_ENHANCER(290),
    FACTION_BLOCK(291),
    FACTION_HUB_BLOCK(292),
    POWER_HOLDER(331),
    POWER_DRAIN_BEAM_COMPUTER(332),
    POWER_DRAIN_BEAM_MODULE(333),
    POWER_SUPPLY_BEAM_COMPUTER(334),
    POWER_SUPPLY_BEAM_MODULE(335),
    DECORATIVE_PANEL_1(336),
    DECORATIVE_PANEL_2(337),
    DECORATIVE_PANEL_3(338),
    DECORATIVE_PANEL_4(339),
    LIGHT_BULB_YELLOW(340),
    SPRITE_BRONZE(341),
    SPRITE_SILVER(342),
    SPRITE_GOLD(343),
    PULSE_CONTROLLER(344),
    PULSE(345),
    FRACTION_EXCEPTION(346),
    SHOP_BLOCK(347),
    GLASS_WEDGE(329),
    GLASS_CORNER(330),
    GLASS_WEDGE_EXT(366),
    GLASS_PENTA(367),
    GLASS_TETRA(368),
    HULL_COLOR_PURPLE(69),
    HULL_COLOR_BROWN(70),
    HULL_COLOR_BLACK(75),
    HULL_COLOR_RED(76),
    HULL_COLOR_BLUE(77),
    HULL_COLOR_GREEN(78),
    HULL_COLOR_YELLOW(79),
    HULL_COLOR_WHITE(81),
    HULL_COLOR_WEDGE_GREY(293),
    HULL_COLOR_WEDGE_PURPLE(294),
    HULL_COLOR_WEDGE_BROWN(295),
    HULL_COLOR_WEDGE_BLACK(296),
    HULL_COLOR_WEDGE_RED(297),
    HULL_COLOR_WEDGE_BLUE(298),
    HULL_COLOR_WEDGE_GREEN(299),
    HULL_COLOR_WEDGE_YELLOW(300),
    HULL_COLOR_WEDGE_WHITE(301),
    HULL_COLOR_CORNER_GREY(302),
    HULL_COLOR_CORNER_PURPLE(303),
    HULL_COLOR_CORNER_BROWN(304),
    HULL_COLOR_CORNER_BLACK(305),
    HULL_COLOR_CORNER_RED(306),
    HULL_COLOR_CORNER_BLUE(307),
    HULL_COLOR_CORNER_GREEN(308),
    HULL_COLOR_CORNER_YELLOW(309),
    HULL_COLOR_CORNER_WHITE(310),
    HULL_COLOR_PENTA_GREY(357),
    HULL_COLOR_PENTA_BLACK(385),
    HULL_COLOR_PENTA_RED(386),
    HULL_COLOR_PENTA_PURPLE(387),
    HULL_COLOR_PENTA_BLUE(388),
    HULL_COLOR_PENTA_GREEN(389),
    HULL_COLOR_PENTA_BROWN(390),
    HULL_COLOR_PENTA_YELLOW(391),
    HULL_COLOR_PENTA_WHITE(392),
    //HULL_COLOR_PENTA_BROWN(403),
    HULL_COLOR_TETRA_GREY(348),
    HULL_COLOR_TETRA_BLACK(393),
    HULL_COLOR_TETRA_RED(394),
    HULL_COLOR_TETRA_PURPLE(395),
    HULL_COLOR_TETRA_BLUE(396),
    HULL_COLOR_TETRA_GREEN(397),
    HULL_COLOR_TETRA_YELLOW(398),
    HULL_COLOR_TETRA_GOLD(399),
    HULL_COLOR_TETRA_WHITE(400),
    HULL_COLOR_TETRA_BROWN(404),
    POWERHULL_COLOR_GREY(263),
    POWERHULL_COLOR_BLACK(264),
    POWERHULL_COLOR_RED(265),
    POWERHULL_COLOR_PURPLE(266),
    POWERHULL_COLOR_BLUE(267),
    POWERHULL_COLOR_GREEN(268),
    POWERHULL_COLOR_BROWN(269),
    POWERHULL_COLOR_YELLOW(270),
    POWERHULL_COLOR_WHITE(271),
    POWERHULL_COLOR_WEDGE_GREY(311),
    POWERHULL_COLOR_WEDGE_BLACK(312),
    POWERHULL_COLOR_WEDGE_RED(313),
    POWERHULL_COLOR_WEDGE_PURPLE(314),
    POWERHULL_COLOR_WEDGE_BLUE(315),
    POWERHULL_COLOR_WEDGE_GREEN(316),
    POWERHULL_COLOR_WEDGE_BROWN(317),
    POWERHULL_COLOR_WEDGE_YELLOW(318),
    POWERHULL_COLOR_WEDGE_WHITE(319),
    POWERHULL_COLOR_CORNER_GREY(320),
    POWERHULL_COLOR_CORNER_BLACK(321),
    POWERHULL_COLOR_CORNER_RED(322),
    POWERHULL_COLOR_CORNER_PURPLE(323),
    POWERHULL_COLOR_CORNER_BLUE(324),
    POWERHULL_COLOR_CORNER_GREEN(325),
    POWERHULL_COLOR_CORNER_BROWN(326),
    POWERHULL_COLOR_CORNER_YELLOW(327),
    POWERHULL_COLOR_CORNER_WHITE(328),
    POWERHULL_COLOR_PENTA_BLACK(369),
    POWERHULL_COLOR_PENTA_RED(370),
    POWERHULL_COLOR_PENTA_PURPLE(371),
    POWERHULL_COLOR_PENTA_BLUE(372),
    POWERHULL_COLOR_PENTA_GREEN(373),
    POWERHULL_COLOR_PENTA_BROWN(374),
    POWERHULL_COLOR_PENTA_YELLOW(375),
    POWERHULL_COLOR_PENTA_WHITE(376),
    POWERHULL_COLOR_PENTA_GREY(401),
    POWERHULL_COLOR_TETRA_BLACK(377),
    POWERHULL_COLOR_TETRA_RED(378),
    POWERHULL_COLOR_TETRA_PURPLE(379),
    POWERHULL_COLOR_TETRA_BLUE(380),
    POWERHULL_COLOR_TETRA_GREEN(381),
    POWERHULL_COLOR_TETRA_BROWN(382),
    POWERHULL_COLOR_TETRA_YELLOW(383),
    POWERHULL_COLOR_TETRA_WHITE(384),
    POWERHULL_COLOR_TETRA_GREY(402),
    POWERHULL_COLOR_CORNER_BLACK_EXT(358),
    POWERHULL_COLOR_CORNER_RED_EXT(359),
    POWERHULL_COLOR_CORNER_PURPLE_EXT(360),
    POWERHULL_COLOR_CORNER_BLUE_EXT(361),
    POWERHULL_COLOR_CORNER_GREEN_EXT(362),
    POWERHULL_COLOR_CORNER_BROWN_EXT(363),
    POWERHULL_COLOR_CORNER_GOLD_EXT(364),
    POWERHULL_COLOR_CORNER_WHITE_EXT(365),
    HULL_COLOR_CORNER_PURPLE_EXT(349),
    HULL_COLOR_CORNER_BROWN_EXT(350),
    HULL_COLOR_CORNER_BLACK_EXT(351),
    HULL_COLOR_CORNER_RED_EXT(352),
    HULL_COLOR_CORNER_BLUE_EXT(353),
    HULL_COLOR_CORNER_GREEN_EXT(354),
    HULL_COLOR_CORNER_YELLOW_EXT(355),
    HULL_COLOR_CORNER_WHITE_EXT(356);

    private final int id;
    private final Constructor<? extends MaterialData> ctor;
    private static Material[] byId = new Material[352];
    private final static Map<String, Material> BY_NAME = new HashMap<String, Material>();

    private Material(final int id) {
        this(id, MaterialData.class);
    }

    private Material(final int id, final Class<? extends MaterialData> data) {
        this.id = id;
        try {
            this.ctor = data.getConstructor(int.class);
        } catch (NoSuchMethodException e) {
            throw new AssertionError();
        } catch (SecurityException e) {
            throw new AssertionError();
        }
    }

    /**
     * Gets the item or block ID of this material
     * @return ID of material
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the MaterialData class associated with this Material
     *
     * @return MaterialData associated with this Material
     */
    public Class<? extends MaterialData> getData() {
        return ctor.getDeclaringClass();
    }
    /**
     * Attempts to get the Material with the given name
     *
     * @param name Name of the material to get
     * @return Material if found, else null
     */
    public static Material getMaterial(final String name) {
        return BY_NAME.get(name);
    }
    /**
     * Attempts to get the Material with the given ID
     *
     * @param id ID of the material to get
     * @return Material if found, else null
     */
    public static Material getMaterial(final int id) {
        if (byId.length > id && id >= 0) {
            return byId[id];
        } else {
            return null;
        }
    }

    static {
        for (Material material : values()) {
        	
        	if (byId.length <= material.id) {
        		byId = Arrays.copyOf(byId, material.id + 1); // Startup time for functionality? Meh, its k
        	}
        	
        	byId[material.id] = material;
        	BY_NAME.put(material.name(), material);
        }
    }
}
