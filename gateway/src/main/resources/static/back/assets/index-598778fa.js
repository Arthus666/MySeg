import{c as Be,_ as T,a as H,i as $,P as xe,b as gt,V as ze,A as Gt,f as Bt,z as qt,C as Ve,u as At,j as Vt,W as Ut,X as je,Y as Yt}from"./default-d6449ec9.js";import{w as He,j as ht,L as Xt,R as pt,c as Zt,i as Rt}from"./collapseMotion-aa2d52e7.js";import{a as _,j as Jt,K as Ge,A as ke,S as Qt,L as it,v as fe,y as te,f as o,o as Ye,z as ea,x as ta,a8 as aa,a9 as na,aa as ia,ab as ra,s as xt}from"./index-1e170dd9.js";import{K as de,E as oa,M as la,_ as ua}from"./Menu-7d70b547.js";import"./index-6780caaa.js";import{D as ca}from"./Dropdown-ad434ecf.js";import{f as Ot,t as sa,a as va,c as da,h as fa,k as ba,j as ma}from"./_flatRest-684801fb.js";import{o as ya}from"./omit-f0e2af22.js";import{_ as Fe,a as ve}from"./index-8be33a14.js";const ga=function(){if(typeof navigator>"u"||typeof window>"u")return!1;var i=navigator.userAgent||navigator.vendor||window.opera;return!!(/(android|bb\d+|meego).+mobile|avantgo|bada\/|blackberry|blazer|compal|elaine|fennec|hiptop|iemobile|ip(hone|od)|iris|kindle|lge |maemo|midp|mmp|mobile.+firefox|netfront|opera m(ob|in)i|palm( os)?|phone|p(ixi|re)\/|plucker|pocket|psp|series(4|6)0|symbian|treo|up\.(browser|link)|vodafone|wap|windows ce|xda|xiino|android|ipad|playbook|silk/i.test(i)||/1207|6310|6590|3gso|4thp|50[1-6]i|770s|802s|a wa|abac|ac(er|oo|s-)|ai(ko|rn)|al(av|ca|co)|amoi|an(ex|ny|yw)|aptu|ar(ch|go)|as(te|us)|attw|au(di|-m|r |s )|avan|be(ck|ll|nq)|bi(lb|rd)|bl(ac|az)|br(e|v)w|bumb|bw-(n|u)|c55\/|capi|ccwa|cdm-|cell|chtm|cldc|cmd-|co(mp|nd)|craw|da(it|ll|ng)|dbte|dc-s|devi|dica|dmob|do(c|p)o|ds(12|-d)|el(49|ai)|em(l2|ul)|er(ic|k0)|esl8|ez([4-7]0|os|wa|ze)|fetc|fly(-|_)|g1 u|g560|gene|gf-5|g-mo|go(\.w|od)|gr(ad|un)|haie|hcit|hd-(m|p|t)|hei-|hi(pt|ta)|hp( i|ip)|hs-c|ht(c(-| |_|a|g|p|s|t)|tp)|hu(aw|tc)|i-(20|go|ma)|i230|iac( |-|\/)|ibro|idea|ig01|ikom|im1k|inno|ipaq|iris|ja(t|v)a|jbro|jemu|jigs|kddi|keji|kgt( |\/)|klon|kpt |kwc-|kyo(c|k)|le(no|xi)|lg( g|\/(k|l|u)|50|54|-[a-w])|libw|lynx|m1-w|m3ga|m50\/|ma(te|ui|xo)|mc(01|21|ca)|m-cr|me(rc|ri)|mi(o8|oa|ts)|mmef|mo(01|02|bi|de|do|t(-| |o|v)|zz)|mt(50|p1|v )|mwbp|mywa|n10[0-2]|n20[2-3]|n30(0|2)|n50(0|2|5)|n7(0(0|1)|10)|ne((c|m)-|on|tf|wf|wg|wt)|nok(6|i)|nzph|o2im|op(ti|wv)|oran|owg1|p800|pan(a|d|t)|pdxg|pg(13|-([1-8]|c))|phil|pire|pl(ay|uc)|pn-2|po(ck|rt|se)|prox|psio|pt-g|qa-a|qc(07|12|21|32|60|-[2-7]|i-)|qtek|r380|r600|raks|rim9|ro(ve|zo)|s55\/|sa(ge|ma|mm|ms|ny|va)|sc(01|h-|oo|p-)|sdk\/|se(c(-|0|1)|47|mc|nd|ri)|sgh-|shar|sie(-|m)|sk-0|sl(45|id)|sm(al|ar|b3|it|t5)|so(ft|ny)|sp(01|h-|v-|v )|sy(01|mb)|t2(18|50)|t6(00|10|18)|ta(gt|lk)|tcl-|tdg-|tel(i|m)|tim-|t-mo|to(pl|sh)|ts(70|m-|m3|m5)|tx-9|up(\.b|g1|si)|utst|v400|v750|veri|vi(rg|te)|vk(40|5[0-3]|-v)|vm40|voda|vulc|vx(52|53|60|61|70|80|81|83|85|98)|w3c(-| )|webc|whit|wi(g |nc|nw)|wmlb|wonu|x700|yas-|your|zeto|zte-/i.test(i==null?void 0:i.substr(0,4)))};function St(i,e){var t=e||{},a=t.defaultValue,n=t.value,r=n===void 0?_():n,u=typeof i=="function"?i():i;r.value!==void 0&&(u=Jt(r)),a!==void 0&&(u=typeof a=="function"?a():a);var c=_(u),l=_(u);Ge(function(){var s=r.value!==void 0?r.value:c.value;e.postState&&(s=e.postState(s)),l.value=s});function d(s){var f=l.value;c.value=s,Qt(l.value)!==s&&e.onChange&&e.onChange(s,f)}return ke(r,function(){c.value=r.value}),[l,d]}function X(i){var e=typeof i=="function"?i():i,t=_(e);function a(n){t.value=n}return[t,a]}function ha(i){var e=_(),t=_(!1);function a(){for(var n=arguments.length,r=new Array(n),u=0;u<n;u++)r[u]=arguments[u];t.value||(He.cancel(e.value),e.value=He(function(){i.apply(void 0,r)}))}return it(function(){t.value=!0,He.cancel(e.value)}),a}function pa(i){var e=_([]),t=_(typeof i=="function"?i():i),a=ha(function(){var r=t.value;e.value.forEach(function(u){r=u(r)}),e.value=[],t.value=r});function n(r){e.value.push(r),a()}return[t,n]}const xa=fe({compatConfig:{MODE:3},name:"TabNode",props:{id:{type:String},prefixCls:{type:String},tab:{type:Object},active:{type:Boolean},closable:{type:Boolean},editable:{type:Object},onClick:{type:Function},onResize:{type:Function},renderWrapper:{type:Function},removeAriaLabel:{type:String},onFocus:{type:Function}},emits:["click","resize","remove","focus"],setup:function(e,t){var a=t.expose,n=t.attrs,r=_();function u(d){var s;(s=e.tab)!==null&&s!==void 0&&s.disabled||e.onClick(d)}a({domRef:r});function c(d){var s;d.preventDefault(),d.stopPropagation(),e.editable.onEdit("remove",{key:(s=e.tab)===null||s===void 0?void 0:s.key,event:d})}var l=te(function(){var d;return e.editable&&e.closable!==!1&&!((d=e.tab)!==null&&d!==void 0&&d.disabled)});return function(){var d,s,f=e.prefixCls,b=e.id,x=e.active,y=e.tab,M=y.key,I=y.tab,P=y.disabled,S=y.closeIcon,m=e.renderWrapper,L=e.removeAriaLabel,q=e.editable,N=e.onFocus,B="".concat(f,"-tab"),D=o("div",{key:M,ref:r,class:Be(B,(d={},T(d,"".concat(B,"-with-remove"),l.value),T(d,"".concat(B,"-active"),x),T(d,"".concat(B,"-disabled"),P),d)),style:n.style,onClick:u},[o("div",{role:"tab","aria-selected":x,id:b&&"".concat(b,"-tab-").concat(M),class:"".concat(B,"-btn"),"aria-controls":b&&"".concat(b,"-panel-").concat(M),"aria-disabled":P,tabindex:P?null:0,onClick:function(W){W.stopPropagation(),u(W)},onKeydown:function(W){[de.SPACE,de.ENTER].includes(W.which)&&(W.preventDefault(),u(W))},onFocus:N},[typeof I=="function"?I():I]),l.value&&o("button",{type:"button","aria-label":L||"remove",tabindex:0,class:"".concat(B,"-remove"),onClick:function(W){W.stopPropagation(),c(W)}},[(S==null?void 0:S())||((s=q.removeIcon)===null||s===void 0?void 0:s.call(q))||"×"])]);return m?m(D):D}}});var Ct={width:0,height:0,left:0,top:0};function Sa(i,e){var t=_(new Map);return Ge(function(){for(var a,n=new Map,r=i.value,u=e.value.get((a=r[0])===null||a===void 0?void 0:a.key)||Ct,c=u.left+u.width,l=0;l<r.length;l+=1){var d=r[l].key,s=e.value.get(d);if(!s){var f;s=e.value.get((f=r[l-1])===null||f===void 0?void 0:f.key)||Ct}var b=n.get(d)||H({},s);b.right=c-b.left-b.width,n.set(d,b)}t.value=new Map(n)}),t}const Mt=fe({compatConfig:{MODE:3},name:"AddButton",inheritAttrs:!1,props:{prefixCls:String,editable:{type:Object},locale:{type:Object,default:void 0}},setup:function(e,t){var a=t.expose,n=t.attrs,r=_();return a({domRef:r}),function(){var u=e.prefixCls,c=e.editable,l=e.locale;return!c||c.showAdd===!1?null:o("button",{ref:r,type:"button",class:"".concat(u,"-nav-add"),style:n.style,"aria-label":(l==null?void 0:l.addAriaLabel)||"Add tab",onClick:function(s){c.onEdit("add",{event:s})}},[c.addIcon?c.addIcon():"+"])}}});var Ca={prefixCls:{type:String},id:{type:String},tabs:{type:Object},rtl:{type:Boolean},tabBarGutter:{type:Number},activeKey:{type:[String,Number]},mobile:{type:Boolean},moreIcon:xe.any,moreTransitionName:{type:String},editable:{type:Object},locale:{type:Object,default:void 0},removeAriaLabel:String,onTabClick:{type:Function}};const Ta=fe({compatConfig:{MODE:3},name:"OperationNode",inheritAttrs:!1,props:Ca,emits:["tabClick"],slots:["moreIcon"],setup:function(e,t){var a=t.attrs,n=t.slots,r=X(!1),u=$(r,2),c=u[0],l=u[1],d=X(null),s=$(d,2),f=s[0],b=s[1],x=function(m){for(var L=e.tabs.filter(function(V){return!V.disabled}),q=L.findIndex(function(V){return V.key===f.value})||0,N=L.length,B=0;B<N;B+=1){q=(q+m+N)%N;var D=L[q];if(!D.disabled){b(D.key);return}}},y=function(m){var L=m.which;if(!c.value){[de.DOWN,de.SPACE,de.ENTER].includes(L)&&(l(!0),m.preventDefault());return}switch(L){case de.UP:x(-1),m.preventDefault();break;case de.DOWN:x(1),m.preventDefault();break;case de.ESC:l(!1);break;case de.SPACE:case de.ENTER:f.value!==null&&e.onTabClick(f.value,m);break}},M=te(function(){return"".concat(e.id,"-more-popup")}),I=te(function(){return f.value!==null?"".concat(M.value,"-").concat(f.value):null}),P=function(m,L){m.preventDefault(),m.stopPropagation(),e.editable.onEdit("remove",{key:L,event:m})};return Ye(function(){ke(f,function(){var S=document.getElementById(I.value);S&&S.scrollIntoView&&S.scrollIntoView(!1)},{flush:"post",immediate:!0})}),ke(c,function(){c.value||b(null)}),function(){var S,m=e.prefixCls,L=e.id,q=e.tabs,N=e.locale,B=e.mobile,D=e.moreIcon,V=D===void 0?((S=n.moreIcon)===null||S===void 0?void 0:S.call(n))||o(oa,null,null):D,W=e.moreTransitionName,K=e.editable,re=e.tabBarGutter,h=e.rtl,v=e.onTabClick,g="".concat(m,"-dropdown"),k=N==null?void 0:N.dropdownAriaLabel,z=T({},h?"marginRight":"marginLeft",re);q.length||(z.visibility="hidden",z.order=1);var j=Be(T({},"".concat(g,"-rtl"),h)),E=B?null:o(ca,{prefixCls:g,trigger:["hover"],visible:c.value,transitionName:W,onVisibleChange:l,overlayClassName:j,mouseEnterDelay:.1,mouseLeaveDelay:.1},{overlay:function(){return o(la,{onClick:function(R){var U=R.key,ne=R.domEvent;v(U,ne),l(!1)},id:M.value,tabindex:-1,role:"listbox","aria-activedescendant":I.value,selectedKeys:[f.value],"aria-label":k!==void 0?k:"expanded dropdown"},{default:function(){return[q.map(function(R){var U,ne,oe=K&&R.closable!==!1&&!R.disabled;return o(ua,{key:R.key,id:"".concat(M.value,"-").concat(R.key),role:"option","aria-controls":L&&"".concat(L,"-panel-").concat(R.key),disabled:R.disabled},{default:function(){return[o("span",null,[typeof R.tab=="function"?R.tab():R.tab]),oe&&o("button",{type:"button","aria-label":e.removeAriaLabel||"remove",tabindex:0,class:"".concat(g,"-menu-item-remove"),onClick:function(le){le.stopPropagation(),P(le,R.key)}},[((U=R.closeIcon)===null||U===void 0?void 0:U.call(R))||((ne=K.removeIcon)===null||ne===void 0?void 0:ne.call(K))||"×"])]}})})]}})},default:function(){return o("button",{type:"button",class:"".concat(m,"-nav-more"),style:z,tabindex:-1,"aria-hidden":"true","aria-haspopup":"listbox","aria-controls":M.value,id:"".concat(L,"-more"),"aria-expanded":c.value,onKeydown:y},[V])}});return o("div",{class:Be("".concat(m,"-nav-operations"),a.class),style:a.style},[E,o(Mt,{prefixCls:m,locale:N,editable:K},null)])}}});var Lt=Symbol("tabsContextKey"),Nt=function(e){ea(Lt,e)},Kt=function(){return ta(Lt,{tabs:_([]),prefixCls:_()})};fe({compatConfig:{MODE:3},name:"TabsContextProvider",inheritAttrs:!1,props:{tabs:{type:Object,default:void 0},prefixCls:{type:String,default:void 0}},setup:function(e,t){var a=t.slots;return Nt(aa(e)),function(){var n;return(n=a.default)===null||n===void 0?void 0:n.call(a)}}});var ka=.1,Tt=.01,Ue=20,kt=Math.pow(.995,Ue);function _a(i,e){var t=X(),a=$(t,2),n=a[0],r=a[1],u=X(0),c=$(u,2),l=c[0],d=c[1],s=X(0),f=$(s,2),b=f[0],x=f[1],y=X(),M=$(y,2),I=M[0],P=M[1],S=_();function m(h){var v=h.touches[0],g=v.screenX,k=v.screenY;r({x:g,y:k}),clearInterval(S.value)}function L(h){if(n.value){h.preventDefault();var v=h.touches[0],g=v.screenX,k=v.screenY,z=g-n.value.x,j=k-n.value.y;e(z,j),r({x:g,y:k});var E=Date.now();x(E-l.value),d(E),P({x:z,y:j})}}function q(){if(n.value){var h=I.value;if(r(null),P(null),h){var v=h.x/b.value,g=h.y/b.value,k=Math.abs(v),z=Math.abs(g);if(Math.max(k,z)<ka)return;var j=v,E=g;S.value=setInterval(function(){if(Math.abs(j)<Tt&&Math.abs(E)<Tt){clearInterval(S.value);return}j*=kt,E*=kt,e(j*Ue,E*Ue)},Ue)}}}var N=_();function B(h){var v=h.deltaX,g=h.deltaY,k=0,z=Math.abs(v),j=Math.abs(g);z===j?k=N.value==="x"?v:g:z>j?(k=v,N.value="x"):(k=g,N.value="y"),e(-k,-k)&&h.preventDefault()}var D=_({onTouchStart:m,onTouchMove:L,onTouchEnd:q,onWheel:B});function V(h){D.value.onTouchStart(h)}function W(h){D.value.onTouchMove(h)}function K(h){D.value.onTouchEnd(h)}function re(h){D.value.onWheel(h)}Ye(function(){var h,v;document.addEventListener("touchmove",W,{passive:!1}),document.addEventListener("touchend",K,{passive:!1}),(h=i.value)===null||h===void 0||h.addEventListener("touchstart",V,{passive:!1}),(v=i.value)===null||v===void 0||v.addEventListener("wheel",re,{passive:!1})}),it(function(){document.removeEventListener("touchmove",W),document.removeEventListener("touchend",K)})}function _t(i,e){var t=_(i);function a(n){var r=typeof n=="function"?n(t.value):n;r!==t.value&&e(r,t.value),t.value=r}return[t,a]}var Pa=function(){var e=_(new Map),t=function(n){return function(r){e.value.set(n,r)}};return na(function(){e.value=new Map}),[t,e]};const Ea=Pa;function Ia(i,e,t,a){if(!ht(i))return i;e=Ot(e,i);for(var n=-1,r=e.length,u=r-1,c=i;c!=null&&++n<r;){var l=sa(e[n]),d=t;if(l==="__proto__"||l==="constructor"||l==="prototype")return i;if(n!=u){var s=c[l];d=a?a(s,l,c):void 0,d===void 0&&(d=ht(s)?s:Xt(e[n+1])?[]:{})}va(c,l,d),c=c[l]}return i}function wa(i,e,t){for(var a=-1,n=e.length,r={};++a<n;){var u=e[a],c=da(i,u);t(c,u)&&Ia(r,Ot(u,i),c)}return r}function Ba(i,e){return wa(i,e,function(t,a){return fa(i,a)})}var Aa=ba(function(i,e){return i==null?{}:Ba(i,e)});const $t=Aa;var Pt={width:0,height:0,left:0,top:0,right:0},Ra=function(){return{id:{type:String},tabPosition:{type:String},activeKey:{type:[String,Number]},rtl:{type:Boolean},animated:{type:Object,default:void 0},editable:{type:Object},moreIcon:xe.any,moreTransitionName:{type:String},mobile:{type:Boolean},tabBarGutter:{type:Number},renderTabBar:{type:Function},locale:{type:Object,default:void 0},onTabClick:{type:Function},onTabScroll:{type:Function}}};const Et=fe({compatConfig:{MODE:3},name:"TabNavList",inheritAttrs:!1,props:Ra(),slots:["moreIcon","leftExtra","rightExtra","tabBarExtraContent"],emits:["tabClick","tabScroll"],setup:function(e,t){var a=t.attrs,n=t.slots,r=Kt(),u=r.tabs,c=r.prefixCls,l=_(),d=_(),s=_(),f=_(),b=Ea(),x=$(b,2),y=x[0],M=x[1],I=te(function(){return e.tabPosition==="top"||e.tabPosition==="bottom"}),P=_t(0,function(C,w){I.value&&e.onTabScroll&&e.onTabScroll({direction:C>w?"left":"right"})}),S=$(P,2),m=S[0],L=S[1],q=_t(0,function(C,w){!I.value&&e.onTabScroll&&e.onTabScroll({direction:C>w?"top":"bottom"})}),N=$(q,2),B=N[0],D=N[1],V=X(0),W=$(V,2),K=W[0],re=W[1],h=X(0),v=$(h,2),g=v[0],k=v[1],z=X(null),j=$(z,2),E=j[0],be=j[1],me=X(null),R=$(me,2),U=R[0],ne=R[1],oe=X(0),A=$(oe,2),_e=A[0],le=A[1],Z=X(0),J=$(Z,2),Ae=J[0],Re=J[1],Pe=pa(new Map),ye=$(Pe,2),Le=ye[0],Ne=ye[1],Oe=Sa(u,Le),Ee=te(function(){return"".concat(c.value,"-nav-operations-hidden")}),F=_(0),Se=_(0);Ge(function(){I.value?e.rtl?(F.value=0,Se.value=Math.max(0,K.value-E.value)):(F.value=Math.min(0,E.value-K.value),Se.value=0):(F.value=Math.min(0,U.value-g.value),Se.value=0)});var Ce=function(w){return w<F.value?F.value:w>Se.value?Se.value:w},Ke=_(),$e=X(),ot=$($e,2),Xe=ot[0],lt=ot[1],Ze=function(){lt(Date.now())},Je=function(){clearTimeout(Ke.value)},ut=function(w,p){w(function(G){var O=Ce(G+p);return O})};_a(l,function(C,w){if(I.value){if(E.value>=K.value)return!1;ut(L,C)}else{if(U.value>=g.value)return!1;ut(D,w)}return Je(),Ze(),!0}),ke(Xe,function(){Je(),Xe.value&&(Ke.value=setTimeout(function(){lt(0)},100))});var ct=function(){var w=arguments.length>0&&arguments[0]!==void 0?arguments[0]:e.activeKey,p=Oe.value.get(w)||{width:0,height:0,left:0,right:0,top:0};if(I.value){var G=m.value;e.rtl?p.right<m.value?G=p.right:p.right+p.width>m.value+E.value&&(G=p.right+p.width-E.value):p.left<-m.value?G=-p.left:p.left+p.width>-m.value+E.value&&(G=-(p.left+p.width-E.value)),D(0),L(Ce(G))}else{var O=B.value;p.top<-B.value?O=-p.top:p.top+p.height>-B.value+U.value&&(O=-(p.top+p.height-U.value)),L(0),D(Ce(O))}},Qe=_(0),et=_(0);Ge(function(){var C,w,p,G,O,Q,ee,Ie=Oe.value;["top","bottom"].includes(e.tabPosition)?(w="width",O=E.value,Q=K.value,ee=_e.value,p=e.rtl?"right":"left",G=Math.abs(m.value)):(w="height",O=U.value,Q=K.value,ee=Ae.value,p="top",G=-B.value);var ie=O;Q+ee>O&&Q<O&&(ie=O-ee);var ge=u.value;if(!ge.length){var he;return he=[0,0],Qe.value=he[0],et.value=he[1],he}for(var we=ge.length,Y=we,ue=0;ue<we;ue+=1){var ce=Ie.get(ge[ue].key)||Pt;if(ce[p]+ce[w]>G+ie){Y=ue-1;break}}for(var pe=0,ae=we-1;ae>=0;ae-=1){var se=Ie.get(ge[ae].key)||Pt;if(se[p]<G){pe=ae+1;break}}return C=[pe,Y],Qe.value=C[0],et.value=C[1],C});var tt=function(){var w,p,G,O,Q,ee=((w=l.value)===null||w===void 0?void 0:w.offsetWidth)||0,Ie=((p=l.value)===null||p===void 0?void 0:p.offsetHeight)||0,ie=((G=f.value)===null||G===void 0?void 0:G.$el)||{},ge=ie.offsetWidth||0,he=ie.offsetHeight||0;be(ee),ne(Ie),le(ge),Re(he);var we=(((O=d.value)===null||O===void 0?void 0:O.offsetWidth)||0)-ge,Y=(((Q=d.value)===null||Q===void 0?void 0:Q.offsetHeight)||0)-he;re(we),k(Y),Ne(function(){var ue=new Map;return u.value.forEach(function(ce){var pe=ce.key,ae=M.value.get(pe),se=(ae==null?void 0:ae.$el)||ae;se&&ue.set(pe,{width:se.offsetWidth,height:se.offsetHeight,left:se.offsetLeft,top:se.offsetTop})}),ue})},st=te(function(){return[].concat(gt(u.value.slice(0,Qe.value)),gt(u.value.slice(et.value+1)))}),Wt=X(),vt=$(Wt,2),zt=vt[0],jt=vt[1],Te=te(function(){return Oe.value.get(e.activeKey)}),dt=_(),ft=function(){He.cancel(dt.value)};ke([Te,I,function(){return e.rtl}],function(){var C={};Te.value&&(I.value?(e.rtl?C.right=ze(Te.value.right):C.left=ze(Te.value.left),C.width=ze(Te.value.width)):(C.top=ze(Te.value.top),C.height=ze(Te.value.height))),ft(),dt.value=He(function(){jt(C)})}),ke([function(){return e.activeKey},Te,Oe,I],function(){ct()},{flush:"post"}),ke([function(){return e.rtl},function(){return e.tabBarGutter},function(){return e.activeKey},function(){return u.value}],function(){tt()},{flush:"post"});var at=function(w){var p=w.position,G=w.prefixCls,O=w.extra;if(!O)return null;var Q=O==null?void 0:O({position:p});return Q?o("div",{class:"".concat(G,"-extra-content")},[Q]):null};return it(function(){Je(),ft()}),function(){var C,w=e.id,p=e.animated,G=e.activeKey,O=e.rtl,Q=e.editable,ee=e.locale,Ie=e.tabPosition,ie=e.tabBarGutter,ge=e.onTabClick,he=a.class,we=a.style,Y=c.value,ue=!!st.value.length,ce="".concat(Y,"-nav-wrap"),pe,ae,se,bt;I.value?O?(ae=m.value>0,pe=m.value+E.value<K.value):(pe=m.value<0,ae=-m.value+E.value<K.value):(se=B.value<0,bt=-B.value+U.value<g.value);var qe={};Ie==="top"||Ie==="bottom"?qe[O?"marginRight":"marginLeft"]=typeof ie=="number"?"".concat(ie,"px"):ie:qe.marginTop=typeof ie=="number"?"".concat(ie,"px"):ie;var mt=u.value.map(function(De,yt){var We=De.key;return o(xa,{id:w,prefixCls:Y,key:We,tab:De,style:yt===0?void 0:qe,closable:De.closable,editable:Q,active:We===G,removeAriaLabel:ee==null?void 0:ee.removeAriaLabel,ref:y(We),onClick:function(Ht){ge(We,Ht)},onFocus:function(){ct(We),Ze(),l.value&&(O||(l.value.scrollLeft=0),l.value.scrollTop=0)}},n)});return o("div",{role:"tablist",class:Be("".concat(Y,"-nav"),he),style:we,onKeydown:function(){Ze()}},[o(at,{position:"left",prefixCls:Y,extra:n.leftExtra},null),o(pt,{onResize:tt},{default:function(){return[o("div",{class:Be(ce,(C={},T(C,"".concat(ce,"-ping-left"),pe),T(C,"".concat(ce,"-ping-right"),ae),T(C,"".concat(ce,"-ping-top"),se),T(C,"".concat(ce,"-ping-bottom"),bt),C)),ref:l},[o(pt,{onResize:tt},{default:function(){return[o("div",{ref:d,class:"".concat(Y,"-nav-list"),style:{transform:"translate(".concat(m.value,"px, ").concat(B.value,"px)"),transition:Xe.value?"none":void 0}},[mt,o(Mt,{ref:f,prefixCls:Y,locale:ee,editable:Q,style:H(H({},mt.length===0?void 0:qe),{},{visibility:ue?"hidden":null})},null),o("div",{class:Be("".concat(Y,"-ink-bar"),T({},"".concat(Y,"-ink-bar-animated"),p.inkBar)),style:zt.value},null)])]}})])]}}),o(Ta,H(H({},e),{},{removeAriaLabel:ee==null?void 0:ee.removeAriaLabel,ref:s,prefixCls:Y,tabs:st.value,class:!ue&&Ee.value}),$t(n,["moreIcon"])),o(at,{position:"right",prefixCls:Y,extra:n.rightExtra},null),o(at,{position:"right",prefixCls:Y,extra:n.tabBarExtraContent},null)])}}}),Oa=fe({compatConfig:{MODE:3},name:"TabPanelList",inheritAttrs:!1,props:{activeKey:{type:[String,Number]},id:{type:String},rtl:{type:Boolean},animated:{type:Object,default:void 0},tabPosition:{type:String},destroyInactiveTabPane:{type:Boolean}},setup:function(e){var t=Kt(),a=t.tabs,n=t.prefixCls;return function(){var r=e.id,u=e.activeKey,c=e.animated,l=e.tabPosition,d=e.rtl,s=e.destroyInactiveTabPane,f=c.tabPane,b=n.value,x=a.value.findIndex(function(y){return y.key===u});return o("div",{class:"".concat(b,"-content-holder")},[o("div",{class:["".concat(b,"-content"),"".concat(b,"-content-").concat(l),T({},"".concat(b,"-content-animated"),f)],style:x&&f?T({},d?"marginRight":"marginLeft","-".concat(x,"00%")):null},[a.value.map(function(y){return Zt(y.node,{key:y.key,prefixCls:b,tabKey:y.key,id:r,animated:f,active:y.key===u,destroyInactiveTabPane:s})})])])}}});var Ma={icon:{tag:"svg",attrs:{viewBox:"64 64 896 896",focusable:"false"},children:[{tag:"defs",attrs:{},children:[{tag:"style",attrs:{}}]},{tag:"path",attrs:{d:"M482 152h60q8 0 8 8v704q0 8-8 8h-60q-8 0-8-8V160q0-8 8-8z"}},{tag:"path",attrs:{d:"M176 474h672q8 0 8 8v60q0 8-8 8H176q-8 0-8-8v-60q0-8 8-8z"}}]},name:"plus",theme:"outlined"};const La=Ma;function It(i){for(var e=1;e<arguments.length;e++){var t=arguments[e]!=null?Object(arguments[e]):{},a=Object.keys(t);typeof Object.getOwnPropertySymbols=="function"&&(a=a.concat(Object.getOwnPropertySymbols(t).filter(function(n){return Object.getOwnPropertyDescriptor(t,n).enumerable}))),a.forEach(function(n){Na(i,n,t[n])})}return i}function Na(i,e,t){return e in i?Object.defineProperty(i,e,{value:t,enumerable:!0,configurable:!0,writable:!0}):i[e]=t,i}var rt=function(e,t){var a=It({},e,t.attrs);return o(Gt,It({},a,{icon:La}),null)};rt.displayName="PlusOutlined";rt.inheritAttrs=!1;const Ka=rt;var wt=0,Dt=function(){return{prefixCls:{type:String},id:{type:String},activeKey:{type:[String,Number]},defaultActiveKey:{type:[String,Number]},direction:{type:String},animated:{type:[Boolean,Object]},renderTabBar:{type:Function},tabBarGutter:{type:Number},tabBarStyle:{type:Object},tabPosition:{type:String},destroyInactiveTabPane:{type:Boolean},hideAdd:Boolean,type:{type:String},size:{type:String},centered:Boolean,onEdit:{type:Function},onChange:{type:Function},onTabClick:{type:Function},onTabScroll:{type:Function},"onUpdate:activeKey":{type:Function},locale:{type:Object,default:void 0},onPrevClick:Function,onNextClick:Function,tabBarExtraContent:xe.any}};function $a(i){return i.map(function(e){if(qt(e)){for(var t=H({},e.props||{}),a=0,n=Object.entries(t);a<n.length;a++){var r=$(n[a],2),u=r[0],c=r[1];delete t[u],t[ia(u)]=c}var l=e.children||{},d=e.key!==void 0?e.key:void 0,s=t.tab,f=s===void 0?l.tab:s,b=t.disabled,x=t.forceRender,y=t.closable,M=t.animated,I=t.active,P=t.destroyInactiveTabPane;return H(H({key:d},t),{},{node:e,closeIcon:l.closeIcon,tab:f,disabled:b===""||b,forceRender:x===""||x,closable:y===""||y,animated:M===""||M,active:I===""||I,destroyInactiveTabPane:P===""||P})}return null}).filter(function(e){return e})}var Da=fe({compatConfig:{MODE:3},name:"InternalTabs",inheritAttrs:!1,props:H(H({},Rt(Dt(),{tabPosition:"top",animated:{inkBar:!0,tabPane:!1}})),{},{tabs:{type:Array}}),slots:["tabBarExtraContent","leftExtra","rightExtra","moreIcon","addIcon","removeIcon","renderTabBar"],setup:function(e,t){var a=t.attrs,n=t.slots;Ve(e.onPrevClick===void 0&&e.onNextClick===void 0,"Tabs","`onPrevClick / @prevClick` and `onNextClick / @nextClick` has been removed. Please use `onTabScroll / @tabScroll` instead."),Ve(e.tabBarExtraContent===void 0,"Tabs","`tabBarExtraContent` prop has been removed. Please use `rightExtra` slot instead."),Ve(n.tabBarExtraContent===void 0,"Tabs","`tabBarExtraContent` slot is deprecated. Please use `rightExtra` slot instead.");var r=At("tabs",e),u=r.prefixCls,c=r.direction,l=r.size,d=r.rootPrefixCls,s=te(function(){return c.value==="rtl"}),f=te(function(){var v=e.animated,g=e.tabPosition;return v===!1||["left","right"].includes(g)?{inkBar:!1,tabPane:!1}:v===!0?{inkBar:!0,tabPane:!0}:H({inkBar:!0,tabPane:!1},Vt(v)==="object"?v:{})}),b=X(!1),x=$(b,2),y=x[0],M=x[1];Ye(function(){M(ga())});var I=St(function(){var v;return(v=e.tabs[0])===null||v===void 0?void 0:v.key},{value:te(function(){return e.activeKey}),defaultValue:e.defaultActiveKey}),P=$(I,2),S=P[0],m=P[1],L=X(function(){return e.tabs.findIndex(function(v){return v.key===S.value})}),q=$(L,2),N=q[0],B=q[1];Ge(function(){var v=e.tabs.findIndex(function(k){return k.key===S.value});if(v===-1){var g;v=Math.max(0,Math.min(N.value,e.tabs.length-1)),m((g=e.tabs[v])===null||g===void 0?void 0:g.key)}B(v)});var D=St(null,{value:te(function(){return e.id})}),V=$(D,2),W=V[0],K=V[1],re=te(function(){return y.value&&!["left","right"].includes(e.tabPosition)?"top":e.tabPosition});Ye(function(){e.id||(K("rc-tabs-".concat(wt)),wt+=1)});var h=function(g,k){var z;(z=e.onTabClick)===null||z===void 0||z.call(e,g,k);var j=g!==S.value;if(m(g),j){var E;(E=e.onChange)===null||E===void 0||E.call(e,g)}};return Nt({tabs:te(function(){return e.tabs}),prefixCls:u}),function(){var v,g=e.id,k=e.type,z=e.tabBarGutter,j=e.tabBarStyle,E=e.locale,be=e.destroyInactiveTabPane,me=e.renderTabBar,R=me===void 0?n.renderTabBar:me,U=e.onTabScroll,ne=e.hideAdd,oe=e.centered,A={id:W.value,activeKey:S.value,animated:f.value,tabPosition:re.value,rtl:s.value,mobile:y.value},_e;k==="editable-card"&&(_e={onEdit:function(Re,Pe){var ye,Le=Pe.key,Ne=Pe.event;(ye=e.onEdit)===null||ye===void 0||ye.call(e,Re==="add"?Ne:Le,Re)},removeIcon:function(){return o(Ut,null,null)},addIcon:n.addIcon?n.addIcon:function(){return o(Ka,null,null)},showAdd:ne!==!0});var le,Z=H(H({},A),{},{moreTransitionName:"".concat(d.value,"-slide-up"),editable:_e,locale:E,tabBarGutter:z,onTabClick:h,onTabScroll:U,style:j});R?le=R(H(H({},Z),{},{DefaultTabBar:Et})):le=o(Et,Z,$t(n,["moreIcon","leftExtra","rightExtra","tabBarExtraContent"]));var J=u.value;return o("div",H(H({},a),{},{id:g,class:Be(J,"".concat(J,"-").concat(re.value),(v={},T(v,"".concat(J,"-").concat(l.value),l.value),T(v,"".concat(J,"-card"),["card","editable-card"].includes(k)),T(v,"".concat(J,"-editable-card"),k==="editable-card"),T(v,"".concat(J,"-centered"),oe),T(v,"".concat(J,"-mobile"),y.value),T(v,"".concat(J,"-editable"),k==="editable-card"),T(v,"".concat(J,"-rtl"),s.value),v),a.class)}),[le,o(Oa,H(H({destroyInactiveTabPane:be},A),{},{animated:f.value}),null)])}}});const Me=fe({compatConfig:{MODE:3},name:"ATabs",inheritAttrs:!1,props:Rt(Dt(),{tabPosition:"top",animated:{inkBar:!0,tabPane:!1}}),slots:["tabBarExtraContent","leftExtra","rightExtra","moreIcon","addIcon","removeIcon","renderTabBar"],setup:function(e,t){var a=t.attrs,n=t.slots,r=t.emit,u=function(l){r("update:activeKey",l),r("change",l)};return function(){var c,l=$a(Bt((c=n.default)===null||c===void 0?void 0:c.call(n)));return o(Da,H(H(H({},ya(e,["onUpdate:activeKey"])),a),{},{onChange:u,tabs:l}),n)}}});var Wa=function(){return{tab:xe.any,disabled:{type:Boolean},forceRender:{type:Boolean},closable:{type:Boolean},animated:{type:Boolean},active:{type:Boolean},destroyInactiveTabPane:{type:Boolean},prefixCls:{type:String},tabKey:{type:[String,Number]},id:{type:String}}};const nt=fe({compatConfig:{MODE:3},name:"ATabPane",inheritAttrs:!1,__ANT_TAB_PANE:!0,props:Wa(),slots:["closeIcon","tab"],setup:function(e,t){var a=t.attrs,n=t.slots,r=_(e.forceRender);ke([function(){return e.active},function(){return e.destroyInactiveTabPane}],function(){e.active?r.value=!0:e.destroyInactiveTabPane&&(r.value=!1)},{immediate:!0});var u=te(function(){return e.active?{}:e.animated?{visibility:"hidden",height:0,overflowY:"hidden"}:{display:"none"}});return function(){var c,l=e.prefixCls,d=e.forceRender,s=e.id,f=e.active,b=e.tabKey;return o("div",{id:s&&"".concat(s,"-panel-").concat(b),role:"tabpanel",tabindex:f?0:-1,"aria-labelledby":s&&"".concat(s,"-tab-").concat(b),"aria-hidden":!f,style:[u.value,a.style],class:["".concat(l,"-tabpane"),f&&"".concat(l,"-tabpane-active"),a.class]},[(f||r.value||d)&&((c=n.default)===null||c===void 0?void 0:c.call(n))])}}});Me.TabPane=nt;Me.install=function(i){return i.component(Me.name,Me),i.component(nt.name,nt),i};var za=Me.TabPane,ja=function(){return{prefixCls:String,title:xe.any,extra:xe.any,bordered:{type:Boolean,default:!0},bodyStyle:{type:Object,default:void 0},headStyle:{type:Object,default:void 0},loading:{type:Boolean,default:!1},hoverable:{type:Boolean,default:!1},type:{type:String},size:{type:String},actions:xe.any,tabList:{type:Array},tabBarExtraContent:xe.any,activeTabKey:String,defaultActiveTabKey:String,cover:xe.any,onTabChange:{type:Function}}},Fa=fe({compatConfig:{MODE:3},name:"ACard",props:ja(),slots:["title","extra","tabBarExtraContent","actions","cover","customTab"],setup:function(e,t){var a=t.slots,n=At("card",e),r=n.prefixCls,u=n.direction,c=n.size,l=function(b){var x=b.map(function(y,M){return xt(y)&&!Yt(y)||!xt(y)?o("li",{style:{width:"".concat(100/b.length,"%")},key:"action-".concat(M)},[o("span",null,[y])]):null});return x},d=function(b){var x;(x=e.onTabChange)===null||x===void 0||x.call(e,b)},s=function(){var b=arguments.length>0&&arguments[0]!==void 0?arguments[0]:[],x;return b.forEach(function(y){y&&ma(y.type)&&y.type.__ANT_CARD_GRID&&(x=!0)}),x};return function(){var f,b,x,y,M,I,P,S,m=e.headStyle,L=m===void 0?{}:m,q=e.bodyStyle,N=q===void 0?{}:q,B=e.loading,D=e.bordered,V=D===void 0?!0:D,W=e.type,K=e.tabList,re=e.hoverable,h=e.activeTabKey,v=e.defaultActiveTabKey,g=e.tabBarExtraContent,k=g===void 0?je((f=a.tabBarExtraContent)===null||f===void 0?void 0:f.call(a)):g,z=e.title,j=z===void 0?je((b=a.title)===null||b===void 0?void 0:b.call(a)):z,E=e.extra,be=E===void 0?je((x=a.extra)===null||x===void 0?void 0:x.call(a)):E,me=e.actions,R=me===void 0?je((y=a.actions)===null||y===void 0?void 0:y.call(a)):me,U=e.cover,ne=U===void 0?je((M=a.cover)===null||M===void 0?void 0:M.call(a)):U,oe=Bt((I=a.default)===null||I===void 0?void 0:I.call(a)),A=r.value,_e=(P={},T(P,"".concat(A),!0),T(P,"".concat(A,"-loading"),B),T(P,"".concat(A,"-bordered"),V),T(P,"".concat(A,"-hoverable"),!!re),T(P,"".concat(A,"-contain-grid"),s(oe)),T(P,"".concat(A,"-contain-tabs"),K&&K.length),T(P,"".concat(A,"-").concat(c.value),c.value),T(P,"".concat(A,"-type-").concat(W),!!W),T(P,"".concat(A,"-rtl"),u.value==="rtl"),P),le=N.padding===0||N.padding==="0px"?{padding:"24px"}:void 0,Z=o("div",{class:"".concat(A,"-loading-block")},null),J=o("div",{class:"".concat(A,"-loading-content"),style:le},[o(Fe,{gutter:8},{default:function(){return[o(ve,{span:22},{default:function(){return[Z]}})]}}),o(Fe,{gutter:8},{default:function(){return[o(ve,{span:8},{default:function(){return[Z]}}),o(ve,{span:15},{default:function(){return[Z]}})]}}),o(Fe,{gutter:8},{default:function(){return[o(ve,{span:6},{default:function(){return[Z]}}),o(ve,{span:18},{default:function(){return[Z]}})]}}),o(Fe,{gutter:8},{default:function(){return[o(ve,{span:13},{default:function(){return[Z]}}),o(ve,{span:9},{default:function(){return[Z]}})]}}),o(Fe,{gutter:8},{default:function(){return[o(ve,{span:4},{default:function(){return[Z]}}),o(ve,{span:3},{default:function(){return[Z]}}),o(ve,{span:16},{default:function(){return[Z]}})]}})]),Ae=h!==void 0,Re=(S={size:"large"},T(S,Ae?"activeKey":"defaultActiveKey",Ae?h:v),T(S,"onChange",d),T(S,"class","".concat(A,"-head-tabs")),S),Pe,ye=K&&K.length?o(Me,Re,{default:function(){return[K.map(function(F){var Se=F.tab,Ce=F.slots,Ke=Ce==null?void 0:Ce.tab;Ve(!Ce,"Card","tabList slots is deprecated, Please use `customTab` instead.");var $e=Se!==void 0?Se:a[Ke]?a[Ke](F):null;return $e=ra(a,"customTab",F,function(){return[$e]}),o(za,{tab:$e,key:F.key,disabled:F.disabled},null)})]},rightExtra:k?function(){return k}:null}):null;(j||be||ye)&&(Pe=o("div",{class:"".concat(A,"-head"),style:L},[o("div",{class:"".concat(A,"-head-wrapper")},[j&&o("div",{class:"".concat(A,"-head-title")},[j]),be&&o("div",{class:"".concat(A,"-extra")},[be])]),ye]));var Le=ne?o("div",{class:"".concat(A,"-cover")},[ne]):null,Ne=o("div",{class:"".concat(A,"-body"),style:N},[B?J:oe]),Oe=R&&R.length?o("ul",{class:"".concat(A,"-actions")},[l(R)]):null;return o("div",{class:_e,ref:"cardContainerRef"},[Pe,Le,oe&&oe.length?Ne:null,Oe])}}});const Qa=Fa;export{Qa as C,St as a,X as b,ga as i,Ea as u};
