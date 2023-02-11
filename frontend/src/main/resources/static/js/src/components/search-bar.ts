import {LitElement, html} from 'lit';
import {customElement} from 'lit/decorators.js';

@customElement('search-bar')
export class SearchBar extends LitElement {

    createRenderRoot() {
        return this; // turn off shadow dom to access external styles
    }
    
    render() {
        return html`
            <nav class="flex items-center">
                <form class="relative w-64">
                    <input type="text" class="border border-gray-400 p-2 rounded-lg w-full" placeholder="Search..." />
                    <button type="submit" class="absolute right-0 top-0 mt-1 mr-2">
                        <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
                    </button>
                </form>
            </nav>
        `;
    }
}
