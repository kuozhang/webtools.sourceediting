/*******************************************************************************
 * Copyright (c) 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.wst.css.core.internal.contentmodel;



/**
 * 
 */
public interface IValID {

	public final static String V_100 = "100"; //$NON-NLS-1$
	public final static String V_200 = "200"; //$NON-NLS-1$
	public final static String V_300 = "300"; //$NON-NLS-1$
	public final static String V_400 = "400"; //$NON-NLS-1$
	public final static String V_500 = "500"; //$NON-NLS-1$
	public final static String V_600 = "600"; //$NON-NLS-1$
	public final static String V_700 = "700"; //$NON-NLS-1$
	public final static String V_800 = "800"; //$NON-NLS-1$
	public final static String V_900 = "900"; //$NON-NLS-1$
	public final static String V_ABOVE = "above"; //$NON-NLS-1$
	public final static String V_ABSOLUTE = "absolute"; //$NON-NLS-1$
	public final static String V_ACTIVEBORDER = "ActiveBorder"; //$NON-NLS-1$
	public final static String V_ACTIVECAPTION = "ActiveCaption"; //$NON-NLS-1$
	public final static String V_ALL = "all"; //$NON-NLS-1$
	public final static String V_ALWAYS = "always"; //$NON-NLS-1$
	public final static String V_APPWORKSPACE = "AppWorkspace"; //$NON-NLS-1$
	public final static String V_AQUA = "aqua"; //$NON-NLS-1$
	public final static String V_ARMENIAN = "armenian"; //$NON-NLS-1$
	public final static String V_AUTO = "auto"; //$NON-NLS-1$
	public final static String V_AVOID = "avoid"; //$NON-NLS-1$
	public final static String V_BACKGROUND = "Background"; //$NON-NLS-1$
	public final static String V_BASELINE = "baseline"; //$NON-NLS-1$
	public final static String V_BEHIND = "behind"; //$NON-NLS-1$
	public final static String V_BELOW = "below"; //$NON-NLS-1$
	public final static String V_BIDI_OVERRIDE = "bidi-override"; //$NON-NLS-1$
	public final static String V_BLACK = "black"; //$NON-NLS-1$
	public final static String V_BLINK = "blink"; //$NON-NLS-1$
	public final static String V_BLOCK = "block"; //$NON-NLS-1$
	public final static String V_BLUE = "blue"; //$NON-NLS-1$
	public final static String V_BOLD = "bold"; //$NON-NLS-1$
	public final static String V_BOLDER = "bolder"; //$NON-NLS-1$
	public final static String V_BOTH = "both"; //$NON-NLS-1$
	public final static String V_BOTTOM = "bottom"; //$NON-NLS-1$
	public final static String V_BUTTONFACE = "ButtonFace"; //$NON-NLS-1$
	public final static String V_BUTTONHIGHLIGHT = "ButtonHighlight"; //$NON-NLS-1$
	public final static String V_BUTTONSHADOW = "ButtonShadow"; //$NON-NLS-1$
	public final static String V_BUTTONTEXT = "ButtonText"; //$NON-NLS-1$
	public final static String V_CAPITALIZE = "capitalize"; //$NON-NLS-1$
	public final static String V_CAPTION = "caption"; //$NON-NLS-1$
	public final static String V_CAPTIONTEXT = "CaptionText"; //$NON-NLS-1$
	public final static String V_CENTER = "center"; //$NON-NLS-1$
	public final static String V_CENTER_LEFT = "center-left"; //$NON-NLS-1$
	public final static String V_CENTER_RIGHT = "center-right"; //$NON-NLS-1$
	public final static String V_CHILD = "child"; //$NON-NLS-1$
	public final static String V_CIRCLE = "circle"; //$NON-NLS-1$
	public final static String V_CJK_IDEOGRAPHIC = "cjk-ideographic"; //$NON-NLS-1$
	public final static String V_CLOSE_QUOTE = "close-quote"; //$NON-NLS-1$
	public final static String V_CODE = "code"; //$NON-NLS-1$
	public final static String V_CONDENSED = "condensed"; //$NON-NLS-1$
	public final static String V_COLLAPSE = "collapse"; //$NON-NLS-1$
	public final static String V_COMPACT = "compact"; //$NON-NLS-1$
	public final static String V_CONTINUOUS = "continuous"; //$NON-NLS-1$
	public final static String V_CROP = "crop"; //$NON-NLS-1$
	public final static String V_CROSS = "cross"; //$NON-NLS-1$
	public final static String V_CROSSHAIR = "crosshair"; //$NON-NLS-1$
	public final static String V_CURSIVE = "cursive"; //$NON-NLS-1$
	public final static String V_DASHED = "dashed"; //$NON-NLS-1$
	public final static String V_DECIMAL = "decimal"; //$NON-NLS-1$
	public final static String V_DECIMAL_LEADING_ZERO = "decimal-leading-zero"; //$NON-NLS-1$
	public final static String V_DEFAULT = "default"; //$NON-NLS-1$
	public final static String V_DIGITS = "digits"; //$NON-NLS-1$
	public final static String V_DISC = "disc"; //$NON-NLS-1$
	public final static String V_DOTTED = "dotted"; //$NON-NLS-1$
	public final static String V_DOUBLE = "double"; //$NON-NLS-1$
	public final static String V_E_RESIZE = "e-resize"; //$NON-NLS-1$
	public final static String V_EMBED = "embed"; //$NON-NLS-1$
	public final static String V_EXPANDED = "expanded"; //$NON-NLS-1$
	public final static String V_EXTRA_CONDENSED = "extra-condensed"; //$NON-NLS-1$
	public final static String V_EXTRA_EXPANDED = "extra-expanded"; //$NON-NLS-1$
	public final static String V_FANTASY = "fantasy"; //$NON-NLS-1$
	public final static String V_FAR_LEFT = "far-left"; //$NON-NLS-1$
	public final static String V_FAR_RIGHT = "far-right"; //$NON-NLS-1$
	public final static String V_FAST = "fast"; //$NON-NLS-1$
	public final static String V_FASTER = "faster"; //$NON-NLS-1$
	public final static String V_FEMALE = "female"; //$NON-NLS-1$
	public final static String V_FIXED = "fixed"; //$NON-NLS-1$
	public final static String V_FUCHSIA = "fuchsia"; //$NON-NLS-1$
	public final static String V_GEORGIAN = "georgian"; //$NON-NLS-1$
	public final static String V_GRAY = "gray"; //$NON-NLS-1$
	public final static String V_GRAYTEXT = "GrayText"; //$NON-NLS-1$
	public final static String V_GREEN = "green"; //$NON-NLS-1$
	public final static String V_GROOVE = "groove"; //$NON-NLS-1$
	public final static String V_HEBREW = "hebrew"; //$NON-NLS-1$
	public final static String V_HELP = "help"; //$NON-NLS-1$
	public final static String V_HIDDEN = "hidden"; //$NON-NLS-1$
	public final static String V_HIDE = "hide"; //$NON-NLS-1$
	public final static String V_HIGH = "high"; //$NON-NLS-1$
	public final static String V_HIGHLIGHT = "Highlight"; //$NON-NLS-1$
	public final static String V_HIGHLIGHTTEXT = "HighlightText"; //$NON-NLS-1$
	public final static String V_HIGHER = "higher"; //$NON-NLS-1$
	public final static String V_HIRAGANA = "hiragana"; //$NON-NLS-1$
	public final static String V_HIRAGANA_IROHA = "hiragana-iroha"; //$NON-NLS-1$
	public final static String V_ICON = "icon"; //$NON-NLS-1$
	public final static String V_INACTIVEBORDER = "InactiveBorder"; //$NON-NLS-1$
	public final static String V_INACTIVECAPTION = "InactiveCaption"; //$NON-NLS-1$
	public final static String V_INACTIVECAPTIONTEXT = "InactiveCaptionText"; //$NON-NLS-1$
	public final static String V_INFOBACKGROUND = "InfoBackground"; //$NON-NLS-1$
	public final static String V_INFOTEXT = "InfoText"; //$NON-NLS-1$
	public final static String V_INLINE = "inline"; //$NON-NLS-1$
	public final static String V_INLINE_TABLE = "inline-table"; //$NON-NLS-1$
	public final static String V_INSET = "inset"; //$NON-NLS-1$
	public final static String V_INSIDE = "inside"; //$NON-NLS-1$
	public final static String V_INVERT = "invert"; //$NON-NLS-1$
	public final static String V_ITALIC = "italic"; //$NON-NLS-1$
	public final static String V_JUSTIFY = "justify"; //$NON-NLS-1$
	public final static String V_KATAKANA = "katakana"; //$NON-NLS-1$
	public final static String V_KATAKANA_IROHA = "katakana-iroha"; //$NON-NLS-1$
	public final static String V_LANDSCAPE = "landscape"; //$NON-NLS-1$
	public final static String V_LARGE = "large"; //$NON-NLS-1$
	public final static String V_LARGER = "larger"; //$NON-NLS-1$
	public final static String V_LEFT = "left"; //$NON-NLS-1$
	public final static String V_LEFT_SIDE = "left-side"; //$NON-NLS-1$
	public final static String V_LEFTWARDS = "leftwards"; //$NON-NLS-1$
	public final static String V_LEVEL = "level"; //$NON-NLS-1$
	public final static String V_LIGHTER = "lighter"; //$NON-NLS-1$
	public final static String V_LIME = "lime"; //$NON-NLS-1$
	public final static String V_LINE_THROUGH = "line-through"; //$NON-NLS-1$
	public final static String V_LIST_ITEM = "list-item"; //$NON-NLS-1$
	public final static String V_LOUD = "loud"; //$NON-NLS-1$
	public final static String V_LOW = "low"; //$NON-NLS-1$
	public final static String V_LOWER = "lower"; //$NON-NLS-1$
	public final static String V_LOWER_ALPHA = "lower-alpha"; //$NON-NLS-1$
	public final static String V_LOWER_GREEK = "lower-greek"; //$NON-NLS-1$
	public final static String V_LOWER_LATIN = "lower-latin"; //$NON-NLS-1$
	public final static String V_LOWER_ROMAN = "lower-roman"; //$NON-NLS-1$
	public final static String V_LOWERCASE = "lowercase"; //$NON-NLS-1$
	public final static String V_LTR = "ltr"; //$NON-NLS-1$
	public final static String V_MALE = "male"; //$NON-NLS-1$
	public final static String V_MARKER = "marker"; //$NON-NLS-1$
	public final static String V_MAROON = "maroon"; //$NON-NLS-1$
	public final static String V_MEDIUM = "medium"; //$NON-NLS-1$
	public final static String V_MENU = "menu"; //$NON-NLS-1$
	public final static String V_MENUTEXT = "MenuText"; //$NON-NLS-1$
	public final static String V_MESSAGE_BOX = "message-box"; //$NON-NLS-1$
	public final static String V_MIDDLE = "middle"; //$NON-NLS-1$
	public final static String V_MIX = "mix"; //$NON-NLS-1$
	public final static String V_MONOSPACE = "monospace"; //$NON-NLS-1$
	public final static String V_MOVE = "move"; //$NON-NLS-1$
	public final static String V_N_RESIZE = "n-resize"; //$NON-NLS-1$
	public final static String V_NARROWER = "narrower"; //$NON-NLS-1$
	public final static String V_NAVY = "navy"; //$NON-NLS-1$
	public final static String V_NE_RESIZE = "ne-resize"; //$NON-NLS-1$
	public final static String V_NO_CLOSE_QUOTE = "no-close-quote"; //$NON-NLS-1$
	public final static String V_NO_OPEN_QUOTE = "no-open-quote"; //$NON-NLS-1$
	public final static String V_NO_REPEAT = "no-repeat"; //$NON-NLS-1$
	public final static String V_NONE = "none"; //$NON-NLS-1$
	public final static String V_NORMAL = "normal"; //$NON-NLS-1$
	public final static String V_NOWRAP = "nowrap"; //$NON-NLS-1$
	public final static String V_NW_RESIZE = "nw-resize"; //$NON-NLS-1$
	public final static String V_OBLIQUE = "oblique"; //$NON-NLS-1$
	public final static String V_OLIVE = "olive"; //$NON-NLS-1$
	public final static String V_ONCE = "once"; //$NON-NLS-1$
	public final static String V_OPEN_QUOTE = "open-quote"; //$NON-NLS-1$
	public final static String V_OUTSET = "outset"; //$NON-NLS-1$
	public final static String V_OUTSIDE = "outside"; //$NON-NLS-1$
	public final static String V_OVERLINE = "overline"; //$NON-NLS-1$
	public final static String V_POINTER = "pointer"; //$NON-NLS-1$
	public final static String V_PORTRAIT = "portrait"; //$NON-NLS-1$
	public final static String V_PRE = "pre"; //$NON-NLS-1$
	public final static String V_PURPLE = "purple"; //$NON-NLS-1$
	public final static String V_RED = "red"; //$NON-NLS-1$
	public final static String V_RELATIVE = "relative"; //$NON-NLS-1$
	public final static String V_REPEAT = "repeat"; //$NON-NLS-1$
	public final static String V_REPEAT_X = "repeat-x"; //$NON-NLS-1$
	public final static String V_REPEAT_Y = "repeat-y"; //$NON-NLS-1$
	public final static String V_RIDGE = "ridge"; //$NON-NLS-1$
	public final static String V_RIGHT = "right"; //$NON-NLS-1$
	public final static String V_RIGHT_SIDE = "right-side"; //$NON-NLS-1$
	public final static String V_RIGHTWARDS = "rightwards"; //$NON-NLS-1$
	public final static String V_RTL = "rtl"; //$NON-NLS-1$
	public final static String V_RUN_IN = "run-in"; //$NON-NLS-1$
	public final static String V_S_RESIZE = "s-resize"; //$NON-NLS-1$
	public final static String V_SANS_SERIF = "sans-serif"; //$NON-NLS-1$
	public final static String V_SCROLL = "scroll"; //$NON-NLS-1$
	public final static String V_SCROLLBAR = "Scrollbar"; //$NON-NLS-1$
	public final static String V_SE_RESIZE = "se-resize"; //$NON-NLS-1$
	public final static String V_SEMI_CONDENSED = "semi-condensed"; //$NON-NLS-1$
	public final static String V_SEMI_EXPANDED = "semi-expanded"; //$NON-NLS-1$
	public final static String V_SEPARATE = "separate"; //$NON-NLS-1$
	public final static String V_SERIF = "serif"; //$NON-NLS-1$
	public final static String V_SHOW = "show"; //$NON-NLS-1$
	public final static String V_SILENT = "silent"; //$NON-NLS-1$
	public final static String V_SILVER = "silver"; //$NON-NLS-1$
	public final static String V_SLOW = "slow"; //$NON-NLS-1$
	public final static String V_SLOWER = "slower"; //$NON-NLS-1$
	public final static String V_SMALL = "small"; //$NON-NLS-1$
	public final static String V_SMALL_CAPS = "small-caps"; //$NON-NLS-1$
	public final static String V_SMALL_CAPTION = "small-caption"; //$NON-NLS-1$
	public final static String V_SMALLER = "smaller"; //$NON-NLS-1$
	public final static String V_SOFT = "soft"; //$NON-NLS-1$
	public final static String V_SOLID = "solid"; //$NON-NLS-1$
	public final static String V_SPELL_OUT = "spell-out"; //$NON-NLS-1$
	public final static String V_SQUARE = "square"; //$NON-NLS-1$
	public final static String V_STATIC = "static"; //$NON-NLS-1$
	public final static String V_STATUS_BAR = "status-bar"; //$NON-NLS-1$
	public final static String V_SUB = "sub"; //$NON-NLS-1$
	public final static String V_SUPER = "super"; //$NON-NLS-1$
	public final static String V_SW_RESIZE = "sw-resize"; //$NON-NLS-1$
	public final static String V_TABLE = "table"; //$NON-NLS-1$
	public final static String V_TABLE_CAPTION = "table-caption"; //$NON-NLS-1$
	public final static String V_TABLE_CELL = "table-cell"; //$NON-NLS-1$
	public final static String V_TABLE_COLUMN = "table-column"; //$NON-NLS-1$
	public final static String V_TABLE_COLUMN_GROUP = "table-column-group"; //$NON-NLS-1$
	public final static String V_TABLE_FOOTER_GROUP = "table-footer-group"; //$NON-NLS-1$
	public final static String V_TABLE_HEADER_GROUP = "table-header-group"; //$NON-NLS-1$
	public final static String V_TABLE_ROW = "table-row"; //$NON-NLS-1$
	public final static String V_TABLE_ROW_GROUP = "table-row-group"; //$NON-NLS-1$
	public final static String V_TEAL = "teal"; //$NON-NLS-1$
	public final static String V_TEXT = "text"; //$NON-NLS-1$
	public final static String V_TEXT_TOP = "text-top"; //$NON-NLS-1$
	public final static String V_TEXT_BOTTOM = "text-bottom"; //$NON-NLS-1$
	public final static String V_THICK = "thick"; //$NON-NLS-1$
	public final static String V_THIN = "thin"; //$NON-NLS-1$
	public final static String V_THREEDDARKSHADOW = "ThreeDDarkShadow"; //$NON-NLS-1$
	public final static String V_THREEDFACE = "ThreeDFace"; //$NON-NLS-1$
	public final static String V_THREEDHIGHLIGHT = "ThreeDHighlight"; //$NON-NLS-1$
	public final static String V_THREEDLIGHTSHADOW = "ThreeDLightShadow"; //$NON-NLS-1$
	public final static String V_THREEDSHADOW = "ThreeDShadow"; //$NON-NLS-1$
	public final static String V_TOP = "top"; //$NON-NLS-1$
	public final static String V_TRANSPARENT = "transparent"; //$NON-NLS-1$
	public final static String V_ULTRA_CONDENSED = "ultra-condensed"; //$NON-NLS-1$
	public final static String V_ULTRA_EXPANDED = "ultra-expanded"; //$NON-NLS-1$
	public final static String V_UNDERLINE = "underline"; //$NON-NLS-1$
	public final static String V_UPPER_ALPHA = "upper-alpha"; //$NON-NLS-1$
	public final static String V_UPPER_LATIN = "upper-latin"; //$NON-NLS-1$
	public final static String V_UPPER_ROMAN = "upper-roman"; //$NON-NLS-1$
	public final static String V_UPPERCASE = "uppercase"; //$NON-NLS-1$
	public final static String V_VISIBLE = "visible"; //$NON-NLS-1$
	public final static String V_W_RESIZE = "w-resize"; //$NON-NLS-1$
	public final static String V_WAIT = "wait"; //$NON-NLS-1$
	public final static String V_WHITE = "white"; //$NON-NLS-1$
	public final static String V_WIDER = "wider"; //$NON-NLS-1$
	public final static String V_WINDOW = "Window"; //$NON-NLS-1$
	public final static String V_WINDOWFRAME = "WindowFrame"; //$NON-NLS-1$
	public final static String V_WINDOWTEXT = "WindowText"; //$NON-NLS-1$
	public final static String V_X_FAST = "x-fast"; //$NON-NLS-1$
	public final static String V_X_HIGH = "x-high"; //$NON-NLS-1$
	public final static String V_X_LARGE = "x-large"; //$NON-NLS-1$
	public final static String V_X_LOUD = "x-loud"; //$NON-NLS-1$
	public final static String V_X_LOW = "x-low"; //$NON-NLS-1$
	public final static String V_X_SLOW = "x-slow"; //$NON-NLS-1$
	public final static String V_X_SMALL = "x-small"; //$NON-NLS-1$
	public final static String V_X_SOFT = "x-soft"; //$NON-NLS-1$
	public final static String V_XX_SMALL = "xx-small"; //$NON-NLS-1$
	public final static String V_XX_LARGE = "xx-large"; //$NON-NLS-1$
	public final static String V_YELLOW = "yellow"; //$NON-NLS-1$
}