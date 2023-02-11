import {LitElement, html} from 'lit';
import {customElement} from 'lit/decorators.js';

@customElement('mega-menu-button')
export class MegaMenu extends LitElement {

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }

    menuToggle(e: Event) {
        const megaMenu = document.querySelector("#mega-menu");
        megaMenu?.classList.toggle("hidden");
    }
    
    render() {
        return html`
            <div>
                <button @click="${this.menuToggle}" class="p-1 border-2 border-gray-600 rounded-lg hover:bg-gray-500 hover:text-white" id="menu-button">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16"></path></svg>
                </button>
            </div>
        `;
    }
}
