import{P as a,v as E,a as m,c as M,_ as W}from"./default-d6449ec9.js";import{e as _}from"./Menu-7d70b547.js";import{c as p}from"./collapseMotion-aa2d52e7.js";import{v as B,a as y,A as L,y as C,f as g,F as R}from"./index-1e170dd9.js";var o={adjustX:1,adjustY:1},r=[0,0],$={topLeft:{points:["bl","tl"],overflow:o,offset:[0,-4],targetOffset:r},topCenter:{points:["bc","tc"],overflow:o,offset:[0,-4],targetOffset:r},topRight:{points:["br","tr"],overflow:o,offset:[0,-4],targetOffset:r},bottomLeft:{points:["tl","bl"],overflow:o,offset:[0,4],targetOffset:r},bottomCenter:{points:["tc","bc"],overflow:o,offset:[0,4],targetOffset:r},bottomRight:{points:["tr","br"],overflow:o,offset:[0,4],targetOffset:r}};const F=$;var H=["prefixCls","arrow","showAction","overlayStyle","trigger","placement","align","getPopupContainer","transitionName","animation","overlayClassName"];const I=B({compatConfig:{MODE:3},props:{minOverlayWidthMatchTrigger:{type:Boolean,default:void 0},arrow:{type:Boolean,default:!1},prefixCls:a.string.def("rc-dropdown"),transitionName:String,overlayClassName:a.string.def(""),openClassName:String,animation:a.any,align:a.object,overlayStyle:{type:Object,default:void 0},placement:a.string.def("bottomLeft"),overlay:a.any,trigger:a.oneOfType([a.string,a.arrayOf(a.string)]).def("hover"),alignPoint:{type:Boolean,default:void 0},showAction:a.array,hideAction:a.array,getPopupContainer:Function,visible:{type:Boolean,default:void 0},defaultVisible:{type:Boolean,default:!1},mouseEnterDelay:a.number.def(.15),mouseLeaveDelay:a.number.def(.1)},emits:["visibleChange","overlayClick"],slots:["overlay"],setup:function(e,f){var s=f.slots,u=f.emit,h=f.expose,l=y(!!e.visible);L(function(){return e.visible},function(n){n!==void 0&&(l.value=n)});var c=y();h({triggerRef:c});var b=function(t){e.visible===void 0&&(l.value=!1),u("visibleChange",!1),u("overlayClick",t)},w=function(t){e.visible===void 0&&(l.value=t),u("visibleChange",t)},P=function(){var t,i=(t=s.overlay)===null||t===void 0?void 0:t.call(s),v={prefixCls:"".concat(e.prefixCls,"-menu"),onClick:b,getPopupContainer:function(){return c.value.getPopupDomNode()}};return g(R,null,[e.arrow&&g("div",{class:"".concat(e.prefixCls,"-arrow")},null),p(i,v,!1)])},O=C(function(){var n=e.minOverlayWidthMatchTrigger,t=n===void 0?!e.alignPoint:n;return t}),x=function(){var t,i=(t=s.default)===null||t===void 0?void 0:t.call(s);return l.value&&i?p(i[0],{class:e.openClassName||"".concat(e.prefixCls,"-open")},!1):i},N=C(function(){return!e.hideAction&&e.trigger.indexOf("contextmenu")!==-1?["click"]:e.hideAction});return function(){var n=e.prefixCls,t=e.arrow,i=e.showAction,v=e.overlayStyle,d=e.trigger,A=e.placement,S=e.align,T=e.getPopupContainer,j=e.transitionName,V=e.animation,k=e.overlayClassName,D=E(e,H);return g(_,m(m({},D),{},{prefixCls:n,ref:c,popupClassName:M(k,W({},"".concat(n,"-show-arrow"),t)),popupStyle:v,builtinPlacements:F,action:d,showAction:i,hideAction:N.value||[],popupPlacement:A,popupAlign:S,popupTransitionName:j,popupAnimation:V,popupVisible:l.value,stretch:O.value?"minWidth":"",onPopupVisibleChange:w,getPopupContainer:T}),{popup:P,default:x})}}});export{I as D};
